
Use a consistent style for parentheses in factory_bot calls.

# Examples

```ruby

# bad
create :user
build :login

# good
create(:user)
build(:login)
# bad
create(:user)
build(:login)

# good
create :user
build :login

# also good
# when method name and first argument are not on same line
create(
  :user
)
build(
  :user,
  name: 'foo'
)
# bad - with `EnforcedStyle: require_parentheses`
FactoryBot.create :user
build :user

# good - with `EnforcedStyle: require_parentheses`
FactoryBot.create(:user)
build(:user)
# bad - with `EnforcedStyle: require_parentheses`
FactoryBot.create :user
FactoryBot.build :user

# good - with `EnforcedStyle: require_parentheses`
FactoryBot.create(:user)
FactoryBot.build(:user)
create :user
build :user
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/FactoryBot/ConsistentParenthesesStyle)