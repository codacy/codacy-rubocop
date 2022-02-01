
This cop detects duplicate field definitions within
the same type

# Examples

```ruby
# good

class UserType < BaseType
  field :name, String, null: true
  field :phone, String, null: true do
    argument :something, String, required: false
  end
end

# bad

class UserType < BaseType
  field :name, String, null: true
  field :phone, String, null: true
  field :phone, String, null: true do
    argument :something, String, required: false
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/FieldUniqueness)