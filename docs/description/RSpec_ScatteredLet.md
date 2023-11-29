
Checks for let scattered across the example group.

Group lets together

# Examples

```ruby
# bad
describe Foo do
  let(:foo) { 1 }
  subject { Foo }
  let(:bar) { 2 }
  before { prepare }
  let!(:baz) { 3 }
end

# good
describe Foo do
  subject { Foo }
  before { prepare }
  let(:foo) { 1 }
  let(:bar) { 2 }
  let!(:baz) { 3 }
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ScatteredLet)