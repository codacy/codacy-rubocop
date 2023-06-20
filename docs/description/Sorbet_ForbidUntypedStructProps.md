
This cop disallows use of `T.untyped` or `T.nilable(T.untyped)`
as a prop type for `T::Struct` or `T::ImmutableStruct`.

# Examples

```ruby

# bad
class SomeClass < T::Struct
  const :foo, T.untyped
  prop :bar, T.nilable(T.untyped)
end

# good
class SomeClass < T::Struct
  const :foo, Integer
  prop :bar, T.nilable(String)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidUntypedStructProps)