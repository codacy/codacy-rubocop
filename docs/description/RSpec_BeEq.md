
Check for expectations where `be(...)` can replace `eq(...)`.

The `be` matcher compares by identity while the `eq` matcher compares
using `==`. Booleans and nil can be compared by identity and therefore
the `be` matcher is preferable as it is a more strict test.

# Examples

```ruby
# bad
expect(foo).to eq(true)
expect(foo).to eq(false)
expect(foo).to eq(nil)

# good
expect(foo).to be(true)
expect(foo).to be(false)
expect(foo).to be(nil)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/BeEq)