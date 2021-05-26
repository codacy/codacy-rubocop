
This cop checks whether field names are snake_case.

# Examples

```ruby
# good

class BanUser < BaseMutation
  argument :user_id, ID, required: true
end

# bad

class BanUser < BaseMutation
  argument :userId, ID, required: true
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/ArgumentName)