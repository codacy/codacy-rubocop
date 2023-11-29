
Enforces the use of `refute_operator(expected, :<, actual)` over `refute(expected < actual)`.

# Examples

```ruby

# bad
refute(expected < actual)

# good
refute_operator(expected, :<, actual)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RefuteOperator)