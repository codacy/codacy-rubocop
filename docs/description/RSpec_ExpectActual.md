
Checks for `expect(...)` calls containing literal values.

Autocorrection is performed when the expected is not a literal.

# Examples

```ruby
# bad
expect(5).to eq(price)
expect(/foo/).to eq(pattern)
expect("John").to eq(name)

# good
expect(price).to eq(5)
expect(pattern).to eq(/foo/)
expect(name).to eq("John")

# bad (not supported autocorrection)
expect(false).to eq(true)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ExpectActual)