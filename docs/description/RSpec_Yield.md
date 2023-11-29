
Checks for calling a block within a stub.

# Examples

```ruby
# bad
allow(foo).to receive(:bar) { |&block| block.call(1) }

# good
expect(foo).to receive(:bar).and_yield(1)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Yield)