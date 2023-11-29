
Check for repeated examples within example groups.

# Examples

```ruby

it 'is valid' do
  expect(user).to be_valid
end

it 'validates the user' do
  expect(user).to be_valid
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/RepeatedExample)