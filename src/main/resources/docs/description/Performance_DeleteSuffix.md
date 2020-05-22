
In Ruby 2.5, `String#delete_suffix` has been added.

This cop identifies places where `gsub(/suffix\z/, '')`
can be replaced by `delete_suffix('suffix')`.

The `delete_suffix('suffix')` method is faster than
`gsub(/suffix\z/, '')`.

# Examples

```ruby

# bad
str.gsub(/suffix\z/, '')
str.gsub!(/suffix\z/, '')
str.gsub(/suffix$/, '')
str.gsub!(/suffix$/, '')

# good
str.delete_suffix('suffix')
str.delete_suffix!('suffix')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/DeleteSuffix)