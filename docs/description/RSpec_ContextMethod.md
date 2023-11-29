
`context` should not be used for specifying methods.

# Examples

```ruby
# bad
context '#foo_bar' do
  # ...
end

context '.foo_bar' do
  # ...
end

# good
describe '#foo_bar' do
  # ...
end

describe '.foo_bar' do
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ContextMethod)