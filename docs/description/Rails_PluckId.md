
This cop enforces the use of `ids` over `pluck(:id)` and `pluck(primary_key)`.

# Examples

```ruby
# bad
User.pluck(:id)
user.posts.pluck(:id)

def self.user_ids
  pluck(primary_key)
end

# good
User.ids
user.posts.ids

def self.user_ids
  ids
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/PluckId)