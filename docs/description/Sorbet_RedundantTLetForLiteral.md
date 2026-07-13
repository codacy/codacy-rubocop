
Checks for redundant `T.let` declarations where the first argument
is a literal whose type Sorbet can infer automatically, so wrapping
it in `T.let` is redundant.

Simple literals (strings, symbols, integers, floats, regexps) infer as
their own class. Regexp literals are the only simple literals whose
inference survives a `.freeze` call (Sorbet 0.6.13304+), so
`T.let(/foo/.freeze, Regexp)` is also redundant; other frozen simple
literals (e.g. `"hello".freeze`) are not inferred and still need `T.let`.

Array literals of simple literals are also inferred:

* A frozen array (`[...].freeze`) infers as a fixed-size tuple, which is
  a subtype of the annotated `T::Array`, so the annotation is redundant.
* An unfrozen array infers as `T::Array[<element type>]`. It is only
  flagged when that inferred type matches the annotation exactly, to
  avoid silently widening (e.g. `["a", nil]` infers a nilable element).

Hashes are excluded: Sorbet infers hash literals as `T.untyped`, so the
annotation is required.

# Examples

```ruby
# bad
MAX_RETRIES = T.let(3, Integer)
GREETING = T.let("hello", String)
RATE = T.let(1.5, Float)
PATTERN = T.let(/foo/, Regexp)
FROZEN_PATTERN = T.let(/foo/.freeze, Regexp)
STATUS = T.let(:active, Symbol)
SHELLS = T.let([:bash, :zsh].freeze, T::Array[Symbol])
NAMES = T.let(["alice", "bob"], T::Array[String])

# good
MAX_RETRIES = 3
GREETING = "hello"
RATE = 1.5
PATTERN = /foo/
FROZEN_PATTERN = /foo/.freeze
STATUS = :active
SHELLS = [:bash, :zsh].freeze
NAMES = ["alice", "bob"]

# good — non-regexp frozen simple literals are not inferred
GREETING = T.let("hello".freeze, String)

# good — hash literals are inferred as T.untyped
OPTIONS = T.let({ verbose: true }, T::Hash[Symbol, T::Boolean])

# good — unfrozen array whose annotation is wider than the inferred type
NAMES = T.let(["alice", "bob"], T::Array[T.nilable(String)])

# good — type is not the literal's own class
value = T.let("hello", T.nilable(String))

# good — instance variables need T.let for Sorbet to track their type
@max_retries = T.let(3, Integer)

# good — local variables may need T.let so Sorbet allows reassignment
count = T.let(0, Integer)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/RedundantTLetForLiteral)