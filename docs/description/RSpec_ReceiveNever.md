
Prefer `not_to receive(...)` over `receive(...).never`.

# Examples

```ruby
# bad
expect(foo).to receive(:bar).never

# good
expect(foo).not_to receive(:bar)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ReceiveNever)