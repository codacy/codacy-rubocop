
This cop detects duplicate argument definitions

# Examples

```ruby
# good

class BanUser < BaseMutation
  argument :user_id, ID, required: true
end

# bad

class BanUser < BaseMutation
  argument :user_id, ID, required: true
  argument :user_id, ID, required: true
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/ArgumentUniqueness)