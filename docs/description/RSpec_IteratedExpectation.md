
Check that `all` matcher is used instead of iterating over an array.

# Examples

```ruby
# bad
it 'validates users' do
  [user1, user2, user3].each { |user| expect(user).to be_valid }
end

# good
it 'validates users' do
  expect([user1, user2, user3]).to all(be_valid)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/IteratedExpectation)