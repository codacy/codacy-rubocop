
Enforces the test to use `assert_empty`
instead of using `assert_equal([], object)` or `assert_equal({}, object)`.

NOTE: Using `assert_empty` makes it impossible to indicate that the expected value is
the literal `[]` or `{}`. Since this removes the ability to express the difference
between those literals, it is disabled by default in consideration of that drawback.
Since the role of replacing the originally intended `assert([], empty_list)` with
`assert_equal([], empty_list)` is handled by `Minitest/AssertWithExpectedArgumentTest`,
this cop may be removed in the future.

# Examples

```ruby
# bad
assert_equal([], object)
assert_equal({}, object)

# good
assert_empty(object)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertEmptyLiteral)