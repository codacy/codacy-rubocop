
Checks for trailing inline comments. Inline comments can
make lines harder to read, especially when they are long.
Placing comments on their own line above the code they
describe is often clearer.

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