
Enforces the test to use `assert_empty`
instead of using `assert_equal([], object)` or `assert_equal({}, object)`.

# Examples

```ruby
# bad
assert_equal([], object)
assert_equal({}, object)

# good
assert_empty(object)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertEmptyLiteral)