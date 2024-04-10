
This cop checks if each argument has an unnecessary camelize.

 # bad

  class UserType < BaseType
    argument :filter, String, required: false
  end

 # bad

  class UserType < BaseType
    field :name, String, "Name of the user", null: true do
      argument :filter, String, required: false
    end
  end

# Examples

```ruby
# good

class UserType < BaseType
  field :name, String, "Name of the user", null: true do
    argument :filter, String, required: false, camelize: false
  end
end

# good

class UserType < BaseType
  argument :filter, String, required: false, camelize: false
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/UnnecessaryArgumentCamelize)