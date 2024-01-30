
Detects redundant message argument in assertion methods.
The message argument `nil` is redundant because it is the default value.

# Examples

```ruby

# bad
assert_equal(expected, actual, nil)

# good
assert_equal(expected, actual)
assert_equal(expected, actual, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RedundantMessageArgument)