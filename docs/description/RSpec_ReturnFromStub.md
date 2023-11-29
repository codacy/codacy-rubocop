
Checks for consistent style of stub's return setting.

Enforces either `and_return` or block-style return in the cases
where the returned value is constant. Ignores dynamic returned values
are the result would be different

This cop can be configured using the `EnforcedStyle` option

# Examples

```ruby
# bad
allow(Foo).to receive(:bar) { "baz" }
expect(Foo).to receive(:bar) { "baz" }

# good
allow(Foo).to receive(:bar).and_return("baz")
expect(Foo).to receive(:bar).and_return("baz")
# also good as the returned value is dynamic
allow(Foo).to receive(:bar) { bar.baz }# bad
allow(Foo).to receive(:bar).and_return("baz")
expect(Foo).to receive(:bar).and_return("baz")

# good
allow(Foo).to receive(:bar) { "baz" }
expect(Foo).to receive(:bar) { "baz" }
# also good as the returned value is dynamic
allow(Foo).to receive(:bar).and_return(bar.baz)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ReturnFromStub)