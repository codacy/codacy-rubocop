
Disallow using `T::Enum`.

# Examples

```ruby

# bad
class MyEnum < T::Enum
  enums do
    A = new
    B = new
  end
end

# good
class MyEnum
  A = "a"
  B = "b"
  C = "c"
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTEnum)