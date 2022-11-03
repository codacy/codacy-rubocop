
Checks whether fields with multiple definitions are grouped together.

# Examples

```ruby
# good

class UserType < BaseType
  field :first_name, String, null: true
  field :first_name, Name, null: true

  def first_name
    object.contact_data.first_name
  end
end

# bad

class UserType < BaseType
  field :first_name, String, null: true

  def first_name
    object.contact_data.first_name
  end
  field :first_name, Name, null: true
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/MultipleFieldDefinitions)