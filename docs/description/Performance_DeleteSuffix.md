
In Ruby 2.5, `String#delete_suffix` has been added.

This cop identifies places where `gsub(/suffix\z/, '')` and `sub(/suffix\z/, '')`
can be replaced by `delete_suffix('suffix')`.

This cop has `SafeMultiline` configuration option that `true` by default because
`suffix$` is unsafe as it will behave incompatible with `delete_suffix?`
for receiver is multiline string.

The `delete_suffix('suffix')` method is faster than `gsub(/suffix\z/, '')`.

# Examples

```ruby

# bad
str.gsub(/suffix\z/, '')
str.gsub!(/suffix\z/, '')

str.sub(/suffix\z/, '')
str.sub!(/suffix\z/, '')

# good
str.delete_suffix('suffix')
str.delete_suffix!('suffix')
# good
str.gsub(/suffix$/, '')
str.gsub!(/suffix$/, '')
str.sub(/suffix$/, '')
str.sub!(/suffix$/, '')
# bad
str.gsub(/suffix$/, '')
str.gsub!(/suffix$/, '')
str.sub(/suffix$/, '')
str.sub!(/suffix$/, '')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/DeleteSuffix)