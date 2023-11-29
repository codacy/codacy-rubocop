
Check for repeated example group descriptions.

# Examples

```ruby
# bad
describe 'cool feature' do
  # example group
end

describe 'cool feature' do
  # example group
end

# bad
context 'when case x' do
  # example group
end

describe 'when case x' do
  # example group
end

# good
describe 'cool feature' do
  # example group
end

describe 'another cool feature' do
  # example group
end

# good
context 'when case x' do
  # example group
end

context 'when another case' do
  # example group
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/RepeatedExampleGroupDescription)