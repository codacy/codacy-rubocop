
This cop checks for trailing inline comments.

# Examples

```ruby

# good
foo.each do |f|
  # Standalone comment
  f.bar
end

# bad
foo.each do |f|
  f.bar # Trailing inline comment
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/InlineComment)