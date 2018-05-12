
This cop checks expressions wrapping styles for multiline memoization.

# Examples

```ruby
# bad
foo ||= (
  bar
  baz
)

# good
foo ||= begin
  bar
  baz
end# bad
foo ||= begin
  bar
  baz
end

# good
foo ||= (
  bar
  baz
)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MultilineMemoization)