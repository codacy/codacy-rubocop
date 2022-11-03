
This cop checks if each field has an unnecessary camelize.

# Examples

```ruby
# good

class UserType < BaseType
  field :name, String, "Name of the user", null: true
end

# bad

class UserType < BaseType
  field :name, "Name of the user", String, null: true, camelize: true
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/UnnecessaryFieldCamelize)