
This cop checks if each field has a description.

# Examples

```ruby
# good

class BanUser < BaseMutation
  argument :uuid, ID, required: true, description: "UUID of the user to ban"
end

# bad

class BanUser < BaseMutation
  argument :uuid, ID, required: true
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/ArgumentDescription)