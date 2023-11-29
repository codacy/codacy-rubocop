
Checks that message expectations do not have a configured response.

# Examples

```ruby
# bad
expect(foo).to receive(:bar).with(42).and_return("hello world")

# good (without spies)
allow(foo).to receive(:bar).with(42).and_return("hello world")
expect(foo).to receive(:bar).with(42)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/StubbedMock)