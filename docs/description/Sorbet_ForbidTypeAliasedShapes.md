
Disallows defining type aliases that contain shapes

# Examples

```ruby

# bad
Foo = T.type_alias { { foo: Integer } }

# good
class Foo
  extend T::Sig

  sig { params(foo: Integer).void }
  def initialize(foo)
    @foo = foo
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTypeAliasedShapes)