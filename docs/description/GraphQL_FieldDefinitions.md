
Checks consistency of field definitions

EnforcedStyle supports two modes:

`group_definitions` : all field definitions should be grouped together.

`define_resolver_after_definition` : if resolver method exists it should
be defined right after the field definition.

# Examples

```ruby
# good

class UserType < BaseType
  field :first_name, String, null: true
  field :last_name, String, null: true

  def first_name
    object.contact_data.first_name
  end

  def last_name
    object.contact_data.last_name
  end
end# good

class UserType < BaseType
  field :first_name, String, null: true

  def first_name
    object.contact_data.first_name
  end

  field :last_name, String, null: true

  def last_name
    object.contact_data.last_name
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/FieldDefinitions)