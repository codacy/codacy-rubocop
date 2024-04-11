
Checks for instance variable usage in specs.

This cop can be configured with the option `AssignmentOnly` which
will configure the cop to only register offenses on instance
variable usage if the instance variable is also assigned within
the spec

# Examples

```ruby
# bad
describe MyClass do
  before { @foo = [] }
  it { expect(@foo).to be_empty }
end

# good
describe MyClass do
  let(:foo) { [] }
  it { expect(foo).to be_empty }
end# rubocop.yml
# RSpec/InstanceVariable:
#   AssignmentOnly: true

# bad
describe MyClass do
  before { @foo = [] }
  it { expect(@foo).to be_empty }
end

# allowed
describe MyClass do
  it { expect(@foo).to be_empty }
end

# good
describe MyClass do
  let(:foo) { [] }
  it { expect(foo).to be_empty }
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/InstanceVariable)