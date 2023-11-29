
Checks if there is an empty line after example blocks.

# Examples

```ruby
# bad
RSpec.describe Foo do
  it 'does this' do
  end
  it 'does that' do
  end
end

# good
RSpec.describe Foo do
  it 'does this' do
  end

  it 'does that' do
  end
end

# fair - it's ok to have non-separated one-liners
RSpec.describe Foo do
  it { one }
  it { two }
end# rubocop.yml
# RSpec/EmptyLineAfterExample:
#   AllowConsecutiveOneLiners: false

# bad
RSpec.describe Foo do
  it { one }
  it { two }
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/EmptyLineAfterExample)