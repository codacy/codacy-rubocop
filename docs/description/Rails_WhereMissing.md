
Use `where.missing(...)` to find missing relationship records.

This cop is enabled in Rails 6.1 or higher.

# Examples

```ruby
# bad
Post.left_joins(:author).where(authors: { id: nil })

# good
Post.where.missing(:author)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/WhereMissing)