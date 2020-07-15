
This cop detects cases where the `:foreign_key` option on associations
is redundant.

# Examples

```ruby
# bad
class Post
  has_many :comments, foreign_key: 'post_id'
end

class Comment
  belongs_to :post, foreign_key: 'post_id'
end

# good
class Post
  has_many :comments
end

class Comment
  belongs_to :author, foreign_key: 'user_id'
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RedundantForeignKey)