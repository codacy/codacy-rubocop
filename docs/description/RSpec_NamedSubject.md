
Checks for explicitly referenced test subjects.

RSpec lets you declare an "implicit subject" using `subject { ... }`
which allows for tests like `it { is_expected.to be_valid }`.
If you need to reference your test subject you should explicitly
name it using `subject(:your_subject_name) { ... }`. Your test subjects
should be the most important object in your tests so they deserve
a descriptive name.

This cop can be configured in your configuration using `EnforcedStyle`,
and `IgnoreSharedExamples` which will not report offenses for implicit
subjects in shared example groups.

# Examples

```ruby
# bad
RSpec.describe User do
  subject { described_class.new }

  it 'is valid' do
    expect(subject.valid?).to be(true)
  end
end

# good
RSpec.describe User do
  subject(:user) { described_class.new }

  it 'is valid' do
    expect(user.valid?).to be(true)
  end
end

# also good
RSpec.describe User do
  subject(:user) { described_class.new }

  it { is_expected.to be_valid }
end# bad
RSpec.describe User do
  subject(:user) { described_class.new }

  it 'is valid' do
    expect(subject.valid?).to be(true)
  end
end

# good
RSpec.describe User do
  subject(:user) { described_class.new }

  it 'is valid' do
    expect(user.valid?).to be(true)
  end
end

# also good
RSpec.describe User do
  subject { described_class.new }

  it { is_expected.to be_valid }
end

# acceptable
RSpec.describe User do
  subject { described_class.new }

  it 'is valid' do
    expect(subject.valid?).to be(true)
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/NamedSubject)