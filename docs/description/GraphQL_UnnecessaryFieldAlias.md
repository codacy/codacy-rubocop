
This cop checks if a field has an unnecessary alias.

# Examples

```ruby
# good

class UserType < BaseType
  field :name, String, "Name of the user", null: true, alias: :real_name
end

# bad

class UserType < BaseType
  field :name, "Name of the user" String, null: true, alias: :name
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/UnnecessaryFieldAlias)