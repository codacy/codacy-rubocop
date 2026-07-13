
Prefer `not_to receive(...)` over `receive(...).never`.

This cop only flags usage with `expect`. It ignores `allow` because
`allow(...).to receive(...).never` is a valid way to ensure a method
is not called, while `allow(...).not_to receive(...)` would have
different semantics.

# Examples

```ruby
# bad
expect(foo).to receive(:bar).never

# good
expect(foo).not_to receive(:bar)

# not flagged by this cop
allow(foo).to receive(:bar).never
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ReceiveNever)