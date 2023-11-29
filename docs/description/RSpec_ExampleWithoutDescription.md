
Checks for examples without a description.

RSpec allows for auto-generated example descriptions when there is no
description provided or the description is an empty one.

This cop removes empty descriptions.
It also defines whether auto-generated description is allowed, based
on the configured style.

This cop can be configured using the `EnforcedStyle` option

# Examples

```ruby
# bad
it('') { is_expected.to be_good }
it '' do
  result = service.call
  expect(result).to be(true)
end

# good
it { is_expected.to be_good }
it do
  result = service.call
  expect(result).to be(true)
end# bad
it('') { is_expected.to be_good }
it do
  result = service.call
  expect(result).to be(true)
end

# good
it { is_expected.to be_good }# bad
it { is_expected.to be_good }
it do
  result = service.call
  expect(result).to be(true)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ExampleWithoutDescription)