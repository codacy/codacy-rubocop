
Check for `once` and `twice` receive counts matchers usage.

# Examples

```ruby
# bad
expect(foo).to receive(:bar).exactly(1).times
expect(foo).to receive(:bar).exactly(2).times
expect(foo).to receive(:bar).at_least(1).times
expect(foo).to receive(:bar).at_least(2).times
expect(foo).to receive(:bar).at_most(1).times
expect(foo).to receive(:bar).at_most(2).times

# good
expect(foo).to receive(:bar).once
expect(foo).to receive(:bar).twice
expect(foo).to receive(:bar).at_least(:once)
expect(foo).to receive(:bar).at_least(:twice)
expect(foo).to receive(:bar).at_most(:once)
expect(foo).to receive(:bar).at_most(:twice).times
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ReceiveCounts)