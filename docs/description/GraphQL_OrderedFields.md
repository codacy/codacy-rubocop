
Field should be alphabetically sorted within groups.

# Examples

```ruby
# good

class UserType < BaseType
  field :name, String, null: true
  field :phone, String, null: true do
    argument :something, String, required: false
  end
end

# good

class UserType < BaseType
  field :phone, String, null: true

  field :name, String, null: true
end

# bad

class UserType < BaseType
  field :phone, String, null: true
  field :name, String, null: true
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/OrderedFields)