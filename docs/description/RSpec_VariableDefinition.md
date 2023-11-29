
Checks that memoized helpers names are symbols or strings.

# Examples

```ruby
# bad
subject('user') { create_user }
let('user_name') { 'Adam' }

# good
subject(:user) { create_user }
let(:user_name) { 'Adam' }# bad
subject(:user) { create_user }
let(:user_name) { 'Adam' }

# good
subject('user') { create_user }
let('user_name') { 'Adam' }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/VariableDefinition)