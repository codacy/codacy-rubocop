
Checks for consistent message expectation style.

This cop can be configured in your configuration using the
`EnforcedStyle` option and supports `--auto-gen-config`.

# Examples

```ruby

# bad
expect(foo).to receive(:bar)

# good
allow(foo).to receive(:bar)
# bad
allow(foo).to receive(:bar)

# good
expect(foo).to receive(:bar)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/MessageExpectation)