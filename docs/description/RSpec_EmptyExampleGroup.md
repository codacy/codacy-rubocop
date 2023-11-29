
Checks if an example group does not include any tests.

# Examples

```ruby
# bad
describe Bacon do
  let(:bacon)      { Bacon.new(chunkiness) }
  let(:chunkiness) { false                 }

  context 'extra chunky' do   # flagged by rubocop
    let(:chunkiness) { true }
  end

  it 'is chunky' do
    expect(bacon.chunky?).to be_truthy
  end
end

# good
describe Bacon do
  let(:bacon)      { Bacon.new(chunkiness) }
  let(:chunkiness) { false                 }

  it 'is chunky' do
    expect(bacon.chunky?).to be_truthy
  end
end

# good
describe Bacon do
  pending 'will add tests later'
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/EmptyExampleGroup)