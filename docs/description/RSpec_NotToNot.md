
Checks for consistent method usage for negating expectations.

# Examples

```ruby
# bad
it '...' do
  expect(false).to_not be_true
end

# good
it '...' do
  expect(false).not_to be_true
end# bad
it '...' do
  expect(false).not_to be_true
end

# good
it '...' do
  expect(false).to_not be_true
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/NotToNot)