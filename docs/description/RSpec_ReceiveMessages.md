
Prefer `receive_messages` over multiple `receive`s on the same object.

# Examples

```ruby
# bad
before do
  allow(Service).to receive(:foo).and_return(bar)
  allow(Service).to receive(:baz).and_return(qux)
end

# good
before do
  allow(Service).to receive_messages(foo: bar, baz: qux)
end

# good - ignore same message
before do
  allow(Service).to receive(:foo).and_return(bar)
  allow(Service).to receive(:foo).and_return(qux)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ReceiveMessages)