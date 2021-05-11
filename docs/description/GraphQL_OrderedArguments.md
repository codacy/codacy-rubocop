
Arguments should be alphabetically sorted within groups.

# Examples

```ruby
# good

class UpdateProfile < BaseMutation
  argument :email, String, required: false
  argument :name, String, required: false
end

# good

class UpdateProfile < BaseMutation
  argument :uuid, ID, required: true

  argument :email, String, required: false
  argument :name, String, required: false
end

# good

class UserType < BaseType
  field :posts, PostType do
    argument :created_after, ISO8601DateTime, required: false
    argument :created_before, ISO8601DateTime, required: false
  end
end

# bad

class UpdateProfile < BaseMutation
  argument :uuid, ID, required: true
  argument :name, String, required: false
  argument :email, String, required: false
end

# bad

class UserType < BaseType
  field :posts, PostType do
    argument :created_before, ISO8601DateTime, required: false
    argument :created_after, ISO8601DateTime, required: false
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/OrderedArguments)