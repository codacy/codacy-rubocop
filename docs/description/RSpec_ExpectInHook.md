
Do not use `expect` in hooks such as `before`.

# Examples

```ruby
# bad
before do
  expect(something).to eq 'foo'
end

# bad
after do
  expect_any_instance_of(Something).to receive(:foo)
end

# good
it do
  expect(something).to eq 'foo'
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ExpectInHook)