
Checks for `let` definitions that come after an example.

# Examples

```ruby
# bad
let(:foo) { bar }

it 'checks what foo does' do
  expect(foo).to be
end

let(:some) { other }

it 'checks what some does' do
  expect(some).to be
end

# good
let(:foo) { bar }
let(:some) { other }

it 'checks what foo does' do
  expect(foo).to be
end

it 'checks what some does' do
  expect(some).to be
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/LetBeforeExamples)