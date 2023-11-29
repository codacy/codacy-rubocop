
Checks for usage of implicit subject (`is_expected` / `should`).

This cop can be configured using the `EnforcedStyle` option

# Examples

```ruby
# bad
it do
  is_expected.to be_truthy
end

# good
it { is_expected.to be_truthy }
it do
  expect(subject).to be_truthy
end# bad
it do
  foo = 1
  is_expected.to be_truthy
end

# good
it do
  foo = 1
  expect(subject).to be_truthy
end
it do
  is_expected.to be_truthy
end# bad
it { is_expected.to be_truthy }

# good
it { expect(subject).to be_truthy }# bad
it { expect(subject).to be_truthy }

# good
it { is_expected.to be_truthy }

# bad
it do
  expect(subject).to be_truthy
end

# good
it do
  is_expected.to be_truthy
end

# good
it { expect(named_subject).to be_truthy }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ImplicitSubject)