
Checks whether some constant value isn't a
mutable literal (e.g. array or hash).

When the `Recursive` option is enabled, mutable literals nested inside
arrays and hashes are also frozen, so an offense on the outermost
unfrozen literal will autocorrect every nested mutable literal as well.
When the outer literal already has `.freeze` appended, the cop descends
into it and reports each outermost unfrozen literal underneath. The
option is disabled by default to preserve existing behavior; opt in to
get strict nested freezing.

Strict mode can be used to freeze all constants, rather than
just literals.
Strict mode is considered an experimental feature. It has not been
updated with an exhaustive list of all methods that will produce
frozen objects so there is a decent chance of getting some false
positives. Luckily, there is no harm in freezing an already
frozen object.

From Ruby 3.0, this cop honours the magic comment
'shareable_constant_value'. When this magic comment is set to any
acceptable value other than none, it will suppress the offenses
raised by this cop. It enforces frozen state.

NOTE: `Regexp` and `Range` literals are frozen objects since Ruby 3.0.

NOTE: From Ruby 3.0, interpolated strings are not frozen when
`# frozen-string-literal: true` is used, so this cop enforces explicit
freezing for such strings.

NOTE: From Ruby 3.0, this cop allows explicit freezing of constants when
the `shareable_constant_value` directive is used.

# Examples

```ruby
# bad
CONST = [1, 2, 3]

# good
CONST = [1, 2, 3].freeze

# good
CONST = <<~TESTING.freeze
  This is a heredoc
TESTING

# good
CONST = Something.new# good - only the outer container needs to be frozen
CONST = [{ a: [], b: 'foo' }].freeze# bad - nested mutable literals must be frozen too
CONST = [{ a: [], b: 'foo' }].freeze

# good
CONST = [{ a: [].freeze, b: 'foo'.freeze }.freeze].freeze# bad
CONST = Something.new

# bad
CONST = Struct.new do
  def foo
    puts 1
  end
end

# good
CONST = Something.new.freeze

# good
CONST = Struct.new do
  def foo
    puts 1
  end
end.freeze# Magic comment - shareable_constant_value: literal

# bad
CONST = [1, 2, 3]

# good
# shareable_constant_value: literal
CONST = [1, 2, 3]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MutableConstant)