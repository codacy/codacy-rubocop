
Enforces correct order of expected and
actual arguments for `assert_equal`.

# Examples

```ruby
# bad
assert_equal foo, 2
assert_equal foo, [1, 2]
assert_equal foo, [1, 2], 'message'

# good
assert_equal 2, foo
assert_equal [1, 2], foo
assert_equal [1, 2], foo, 'message'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/LiteralAsActualArgument)