
Check if using Minitest-like matchers.

Check the use of minitest-like matchers
starting with `assert_` or `refute_`.

# Examples

```ruby
# bad
assert_equal(a, b)
assert_equal a, b, "must be equal"
assert_not_includes a, b
refute_equal(a, b)
assert_nil a
refute_empty(b)
assert_true(a)
assert_false(a)

# good
expect(b).to eq(a)
expect(b).to(eq(a), "must be equal")
expect(a).not_to include(b)
expect(b).not_to eq(a)
expect(a).to eq(nil)
expect(a).not_to be_empty
expect(a).to be(true)
expect(a).to be(false)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpecRails/MinitestAssertions)