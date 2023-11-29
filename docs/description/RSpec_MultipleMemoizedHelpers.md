
Checks if example groups contain too many `let` and `subject` calls.

This cop is configurable using the `Max` option and the `AllowSubject`
which will configure the cop to only register offenses on calls to
`let` and not calls to `subject`.

# Examples

```ruby
# bad
describe MyClass do
  let(:foo) { [] }
  let(:bar) { [] }
  let!(:baz) { [] }
  let(:qux) { [] }
  let(:quux) { [] }
  let(:quuz) { {} }
end

describe MyClass do
  let(:foo) { [] }
  let(:bar) { [] }
  let!(:baz) { [] }

  context 'when stuff' do
    let(:qux) { [] }
    let(:quux) { [] }
    let(:quuz) { {} }
  end
end

# good
describe MyClass do
  let(:bar) { [] }
  let!(:baz) { [] }
  let(:qux) { [] }
  let(:quux) { [] }
  let(:quuz) { {} }
end

describe MyClass do
  context 'when stuff' do
    let(:foo) { [] }
    let(:bar) { [] }
    let!(:booger) { [] }
  end

  context 'when other stuff' do
    let(:qux) { [] }
    let(:quux) { [] }
    let(:quuz) { {} }
  end
end# rubocop.yml
# RSpec/MultipleMemoizedHelpers:
#   AllowSubject: false

# bad - `subject` counts towards memoized helpers
describe MyClass do
  subject { {} }
  let(:foo) { [] }
  let(:bar) { [] }
  let!(:baz) { [] }
  let(:qux) { [] }
  let(:quux) { [] }
end# rubocop.yml
# RSpec/MultipleMemoizedHelpers:
#   Max: 1

# bad
describe MyClass do
  let(:foo) { [] }
  let(:bar) { [] }
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/MultipleMemoizedHelpers)