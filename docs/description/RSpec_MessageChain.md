
Check that chains of messages are not being stubbed.

# Examples

```ruby
# bad
allow(foo).to receive_message_chain(:bar, :baz).and_return(42)

# good
thing = Thing.new(baz: 42)
allow(foo).to receive(:bar).and_return(thing)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/MessageChain)