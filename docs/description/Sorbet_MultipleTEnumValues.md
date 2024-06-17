
Disallow creating a `T::Enum` with less than two values.

# Examples

```ruby

# bad
class ErrorMessages < T::Enum
  enums do
    ServerError = new("There was a server error.")
  end
end

# good
class ErrorMessages < T::Enum
  enums do
    ServerError = new("There was a server error.")
    NotFound = new("The resource was not found.")
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/MultipleTEnumValues)