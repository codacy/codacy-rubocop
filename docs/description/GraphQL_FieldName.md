
This cop checks whether field names are snake_case.

# Examples

```ruby
# good

class UserType < BaseType
  field :first_name, String, null: true
end

# bad

class UserType < BaseType
  field :firstName, String, null: true
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/FieldName)