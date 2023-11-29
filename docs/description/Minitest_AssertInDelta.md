
Enforces the test to use `assert_in_delta`
instead of using `assert_equal` to compare floats.

# Examples

```ruby
# bad
assert_equal(0.2, actual)
assert_equal(0.2, actual, 'message')

# good
assert_in_delta(0.2, actual)
assert_in_delta(0.2, actual, 0.001, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertInDelta)