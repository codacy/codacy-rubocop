
Checks for trailing comma in array literals.
The configuration options are:

* `consistent_comma`: Requires a comma after the last item of all non-empty, multiline array
literals.
* `comma`: Requires a comma after the last item in an array, but only when each item is on
its own line.
* `diff_comma`: Requires a comma after the last item in an array, but only when that item is
followed by an immediate newline.
* `no_comma`: Does not require a comma after the last item in an array

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
]

# bad
a = [1, 2,
     3, 4]

# good
a = [1, 2,
     3, 4,]# bad
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
]

# bad
a = [1, 2,
     3, 4,]

# good
a = [1, 2,
     3, 4]# bad
a = [1, 2,]

# good
a = [
  1,
  2
]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TrailingCommaInArrayLiteral)