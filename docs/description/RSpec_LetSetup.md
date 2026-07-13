
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

# good
describe 'a widget' do
  let!(:my_widget) { create(:widget) }
  context 'when visiting its page' do
    let!(:my_widget) { create(:widget, name: 'Special') }
    it 'counts widgets' do
      expect(Widget.count).to eq(1)
    end
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/LetSetup)