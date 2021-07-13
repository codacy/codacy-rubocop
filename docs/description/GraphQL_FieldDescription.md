
This cop checks if each field has a description.

# Examples

```ruby
# good

class UserType < BaseType
  field :name, String, "Name of the user", null: true
end

# bad

class UserType < BaseType
  field :name, String, null: true
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/FieldDescription)