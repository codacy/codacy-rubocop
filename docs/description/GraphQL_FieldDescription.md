
This cop checks if each field has a description.

Fields built from a resolver, mutation or subscription class are not
flagged: graphql-ruby takes their description from that class.

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

# good

class UserType < BaseType
  field :posts, resolver: PostsResolver
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/FieldDescription)