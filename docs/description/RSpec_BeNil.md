
Ensures a consistent style is used when matching `nil`.

You can either use the more specific `be_nil` matcher, or the more
generic `be` matcher with a `nil` argument.

This cop can be configured using the `EnforcedStyle` option

# Examples

```ruby
# bad
expect(foo).to be(nil)

# good
expect(foo).to be_nil# bad
expect(foo).to be_nil

# good
expect(foo).to be(nil)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/BeNil)