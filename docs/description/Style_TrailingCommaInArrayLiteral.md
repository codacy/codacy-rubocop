
This cop checks for trailing comma in array literals.
The configuration options are:

* `consistent_comma`: Requires a comma after the
last item of all non-empty, multiline array literals.
* `comma`: Requires a comma after last item in an array,
but only when each item is on its own line.
* `no_comma`: Does not requires a comma after the
last item in an array

# Examples

```ruby
# bad
a = [1, 2,]

# good
a = [1, 2]

# good
a = [
  1, 2,
  3,
]

# good
a = [
  1, 2, 3,
]

# good
a = [
  1,
  2,
]# bad
a = [1, 2,]

# good
a = [1, 2]

# bad
a = [
  1, 2,
  3,
]

# good
a = [
  1, 2,
  3
]

# bad
a = [
  1, 2, 3,
]

# good
a = [
  1, 2, 3
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
  2
]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TrailingCommaInArrayLiteral)