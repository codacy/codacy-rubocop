
Checks for useless constant scoping. Private constants must be defined using
`private_constant` or `class << self`. Even if `private` access modifier is used,
it is public scope despite its appearance.

It does not support autocorrection due to behavior change and multiple ways to fix it.
Or a public constant may be intended.

# Examples

```ruby

# bad
class Foo
  private
  PRIVATE_CONST = 42
end

# good
class Foo
  PRIVATE_CONST = 42
  private_constant :PRIVATE_CONST
end

# good
class Foo
  class << self
    private
    PRIVATE_CONST = 42
  end
end

# good
class Foo
  PUBLIC_CONST = 42 # If private scope is not intended.
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UselessConstantScoping)