
Checks for before/around/after hooks that come after an example.

# Examples

```ruby
# bad
it 'checks what foo does' do
  expect(foo).to be
end

before { prepare }
after { clean_up }

# good
before { prepare }
after { clean_up }

it 'checks what foo does' do
  expect(foo).to be
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/HooksBeforeExamples)