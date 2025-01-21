
Checks if examples are focused.

This cop does not support autocorrection in some cases.

# Examples

```ruby
# bad
describe MyClass, focus: true do
end

describe MyClass, :focus do
end

fdescribe MyClass do
end

# good
describe MyClass do
end

# bad
fdescribe 'test' do; end

# good
describe 'test' do; end

# bad
shared_examples 'test', focus: true do; end

# good
shared_examples 'test' do; end

# bad
shared_context 'test', focus: true do; end

# good
shared_context 'test' do; end

# bad (does not support autocorrection)
focus 'test' do; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Focus)