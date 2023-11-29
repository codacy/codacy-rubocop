
Checks that chains of messages contain more than one element.

# Examples

```ruby
# bad
allow(foo).to receive_message_chain(:bar).and_return(42)

# good
allow(foo).to receive(:bar).and_return(42)

# also good
allow(foo).to receive(:bar, :baz)
allow(foo).to receive("bar.baz")
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/SingleArgumentMessageChain)