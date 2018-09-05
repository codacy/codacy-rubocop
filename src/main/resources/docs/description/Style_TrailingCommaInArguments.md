
This cop checks for trailing comma in argument lists.

# Examples

```ruby
# bad
method(1, 2,)

# good
method(
  1, 2,
  3,
)

# good
method(
  1,
  2,
)# bad
method(1, 2,)

# good
method(
  1,
  2,
)# bad
method(1, 2,)

# good
method(
  1,
  2
)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TrailingCommaInArguments)