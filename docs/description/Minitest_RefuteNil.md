
Enforces the test to use `refute_nil` instead of using
`refute_equal(nil, something)`, `refute(something.nil?)`, or `refute_predicate(something, :nil?)`.

# Examples

```ruby
# bad
refute_equal(nil, actual)
refute_equal(nil, actual, 'message')
refute(actual.nil?)
refute(actual.nil?, 'message')
refute_predicate(object, :nil?)
refute_predicate(object, :nil?, 'message')

# good
refute_nil(actual)
refute_nil(actual, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RefuteNil)