
This cop checks for a line break before the first element in a
multi-line array.

# Examples

```ruby

# bad
[ :a,
  :b]

# good
[
  :a,
  :b]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/FirstArrayElementLineBreak)