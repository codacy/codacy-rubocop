
Check for repeated describe and context block body.

# Examples

```ruby
# bad
describe 'cool feature x' do
  it { cool_predicate }
end

describe 'cool feature y' do
  it { cool_predicate }
end

# good
describe 'cool feature' do
  it { cool_predicate }
end

describe 'another cool feature' do
  it { another_predicate }
end

# good
context 'when case x', :tag do
  it { cool_predicate }
end

context 'when case y' do
  it { cool_predicate }
end

# good
context Array do
  it { is_expected.to respond_to :each }
end

context Hash do
  it { is_expected.to respond_to :each }
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/RepeatedExampleGroupBody)