
Do not use `expect` in let.

# Examples

```ruby
# bad
let(:foo) do
  expect(something).to eq 'foo'
end

# good
it do
  expect(something).to eq 'foo'
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ExpectInLet)