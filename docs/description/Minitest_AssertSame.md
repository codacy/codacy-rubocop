
Enforces the use of `assert_same(expected, actual)`
over `assert(expected.equal?(actual))`.

NOTE: Use `assert_same` only when there is a need to compare by identity.
      Otherwise, use `assert_equal`.

# Examples

```ruby
# bad
assert(expected.equal?(actual))
assert_equal(expected.object_id, actual.object_id)

# good
assert_same(expected, actual)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertSame)