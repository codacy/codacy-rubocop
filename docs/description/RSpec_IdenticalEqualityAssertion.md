
Checks for equality assertions with identical expressions on both sides.

# Examples

```ruby
# bad
expect(foo.bar).to eq(foo.bar)
expect(foo.bar).to eql(foo.bar)

# good
expect(foo.bar).to eq(2)
expect(foo.bar).to eql(2)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/IdenticalEqualityAssertion)