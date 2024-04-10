
Use a consistent style for parentheses in factory bot calls.

# Examples

```ruby

# bad
create :user
build(:user)
create(:login)
create :login
# good
create(:user)
create(:user)
create(:login)
build(:login)
# good
create :user
build :user
create :login
create :login

# also good
# when method name and first argument are not on same line
create(
  :user
)
build(
  :user,
  name: 'foo'
)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/FactoryBot/ConsistentParenthesesStyle)