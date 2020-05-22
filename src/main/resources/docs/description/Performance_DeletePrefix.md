
In Ruby 2.5, `String#delete_prefix` has been added.

This cop identifies places where `gsub(/\Aprefix/, '')`
can be replaced by `delete_prefix('prefix')`.

The `delete_prefix('prefix')` method is faster than
`gsub(/\Aprefix/, '')`.

# Examples

```ruby

# bad
str.gsub(/\Aprefix/, '')
str.gsub!(/\Aprefix/, '')
str.gsub(/^prefix/, '')
str.gsub!(/^prefix/, '')

# good
str.delete_prefix('prefix')
str.delete_prefix!('prefix')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/DeletePrefix)