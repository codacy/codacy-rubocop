
Checks for proper shared_context and shared_examples usage.

If there are no examples defined, use shared_context.
If there is no setup defined, use shared_examples.

With `Strict: true`, `shared_context` is flagged whenever it contains
any examples, even if it also contains setup code.

# Examples

```ruby
# bad
RSpec.shared_context 'only examples here' do
  it 'does x' do
  end

  it 'does y' do
  end
end

# good
RSpec.shared_examples 'only examples here' do
  it 'does x' do
  end

  it 'does y' do
  end
end

# bad
RSpec.shared_examples 'only setup here' do
  subject(:foo) { :bar }

  let(:baz) { :bazz }

  before do
    something
  end
end

# good
RSpec.shared_context 'only setup here' do
  subject(:foo) { :bar }

  let(:baz) { :bazz }

  before do
    something
  end
end

# bad - shared_context with examples is flagged
RSpec.shared_context 'setup and examples' do
  let(:foo) { :bar }

  it 'does x' do
  end
end

# good - split into separate shared_context and shared_examples
RSpec.shared_context 'setup' do
  let(:foo) { :bar }
end

RSpec.shared_examples 'examples' do
  it 'does x' do
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/SharedContext)