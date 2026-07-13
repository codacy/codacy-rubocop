
Prevents unnecessary `T.let` where Sorbet infers the type automatically.

When a signature parameter is assigned to an instance variable in
`initialize`, the type is inferred from the signature.

When a constant is assigned a constructor call (`.new`), optionally
followed by `.freeze` (Sorbet 0.6.13304+), the type is inferred from
the class being instantiated. Generic classes (e.g. `Set`) are
excluded: Sorbet infers their constructor calls as applied types like
`T::Set[T.untyped]`, so an annotation is still required.

# Examples

```ruby

# bad
sig { params(a: Integer) }
def initialize(a)
  @a = T.let(a, Integer)
end

# good
sig { params(a: Integer) }
def initialize(a)
  @a = a
end

# good
sig { params(a: Integer) }
def initialize(a)
  @a = T.let(a, T.any(Integer, String))
end

# bad
DEFAULT_PATH = T.let(Pathname.new("/usr/local").freeze, Pathname)

# good
DEFAULT_PATH = Pathname.new("/usr/local").freeze

# good — generic classes are not inferred, so T.let is required
LICENSES = T.let(Set.new(["mit"]).freeze, T::Set[String])

# good — instance variables are only inferred from signature parameters
@path = T.let(Pathname.new("/usr/local"), Pathname)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/RedundantTLet)