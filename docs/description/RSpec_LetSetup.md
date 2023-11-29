
Checks unreferenced `let!` calls being used for test setup.

# Examples

```ruby
# bad
let!(:my_widget) { create(:widget) }

it 'counts widgets' do
  expect(Widget.count).to eq(1)
end

# good
it 'counts widgets' do
  create(:widget)
  expect(Widget.count).to eq(1)
end

# good
before { create(:widget) }

it 'counts widgets' do
  expect(Widget.count).to eq(1)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/LetSetup)