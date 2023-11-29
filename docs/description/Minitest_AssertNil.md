
Enforces the test to use `assert_nil` instead of using
`assert_equal(nil, something)`, `assert(something.nil?)`, or `assert_predicate(something, :nil?)`.

# Examples

```ruby
# bad
assert_equal(nil, actual)
assert_equal(nil, actual, 'message')
assert(object.nil?)
assert(object.nil?, 'message')
assert_predicate(object, :nil?)
assert_predicate(object, :nil?, 'message')

# good
assert_nil(actual)
assert_nil(actual, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertNil)