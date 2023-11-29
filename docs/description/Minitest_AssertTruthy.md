
Enforces the test to use `assert(actual)` instead of using `assert_equal(true, actual)`.

# Examples

```ruby
# bad
assert_equal(true, actual)
assert_equal(true, actual, 'message')

# good
assert(actual)
assert(actual, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertTruthy)