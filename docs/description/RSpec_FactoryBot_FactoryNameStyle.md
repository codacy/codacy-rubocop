
Checks for name style for argument of FactoryBot::Syntax::Methods.

# Examples

```ruby
# bad
create('user')
build "user", username: "NAME"

# good
create(:user)
build :user, username: "NAME"# bad
create(:user)
build :user, username: "NAME"

# good
create('user')
build "user", username: "NAME"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/FactoryBot/FactoryNameStyle)