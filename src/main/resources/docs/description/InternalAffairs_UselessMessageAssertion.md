
Checks that cops are not tested using `described_class::MSG`.

# Examples

```ruby

# bad
expect(cop.messages).to eq([described_class::MSG])

# good
expect(cop.messages).to eq(['Do not write bad code like that.'])
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/InternalAffairs/UselessMessageAssertion)