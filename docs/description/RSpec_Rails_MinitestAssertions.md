
Check if using Minitest matchers.

# Examples

```ruby
# bad
assert_equal(a, b)
assert_equal a, b, "must be equal"
refute_equal(a, b)

# good
expect(b).to eq(a)
expect(b).to(eq(a), "must be equal")
expect(b).not_to eq(a)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Rails/MinitestAssertions)