
Checks for a line break before the first element in a
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

# good
[:a, :b]
# bad
[ :a, {
  :b => :c
}]

# good
[
  :a, {
  :b => :c
}]
# good
[:a, {
  :b => :c
}]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/FirstArrayElementLineBreak)