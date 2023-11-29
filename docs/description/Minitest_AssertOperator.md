
Enforces the use of `assert_operator(expected, :<, actual)` over `assert(expected < actual)`.

# Examples

```ruby

# bad
assert(expected < actual)

# good
assert_operator(expected, :<, actual)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertOperator)