
Checks for name style for argument of FactoryBot::Syntax::Methods.

# Examples

```ruby
# bad
create('user')
build "user", username: "NAME"

# good
create(:user)
build :user, username: "NAME"

# good - namespaced models
create('users/internal')# bad
create(:user)
build :user, username: "NAME"

# good
create('user')
build "user", username: "NAME"
# bad - with `EnforcedStyle: symbol`
FactoryBot.create('user')
create('user')

# good - with `EnforcedStyle: symbol`
FactoryBot.create(:user)
create(:user)
# bad - with `EnforcedStyle: symbol`
FactoryBot.create(:user)
FactoryBot.build "user", username: "NAME"

# good - with `EnforcedStyle: symbol`
FactoryBot.create('user')
FactoryBot.build "user", username: "NAME"
FactoryBot.create(:user)
create(:user)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/FactoryBot/FactoryNameStyle)