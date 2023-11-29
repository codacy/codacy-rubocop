
Enforces the use of `refute(object)` over `assert_equal(false, object)`.

# Examples

```ruby
# bad
assert_equal(false, actual)
assert_equal(false, actual, 'message')

assert(!test)
assert(!test, 'message')

# good
refute(actual)
refute(actual, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RefuteFalse)