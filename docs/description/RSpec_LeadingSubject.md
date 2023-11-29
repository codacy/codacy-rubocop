
Enforce that subject is the first definition in the test.

# Examples

```ruby
# bad
let(:params) { blah }
subject { described_class.new(params) }

before { do_something }
subject { described_class.new(params) }

it { expect_something }
subject { described_class.new(params) }
it { expect_something_else }

# good
subject { described_class.new(params) }
let(:params) { blah }

# good
subject { described_class.new(params) }
before { do_something }

# good
subject { described_class.new(params) }
it { expect_something }
it { expect_something_else }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/LeadingSubject)