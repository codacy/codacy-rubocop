
This cop checks for trailing comma in array literals.

# Examples

```ruby
# bad
a = [1, 2,]

# good
a = [
  1, 2,
  3,
]

# good
a = [
  1,
  2,
]# bad
a = [1, 2,]

# good
a = [
  1,
  2,
]# bad
a = [1, 2,]

# good
a = [
  1,
  2
]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TrailingCommaInArrayLiteral)