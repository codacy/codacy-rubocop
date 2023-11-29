
Checks that memoized helper names use the configured style.

Variables can be excluded from checking using the `AllowedPatterns`
option.

# Examples

```ruby
# bad
subject(:userName1) { 'Adam' }
let(:userName2) { 'Adam' }

# good
subject(:user_name_1) { 'Adam' }
let(:user_name_2) { 'Adam' }# bad
subject(:user_name_1) { 'Adam' }
let(:user_name_2) { 'Adam' }

# good
subject(:userName1) { 'Adam' }
let(:userName2) { 'Adam' }# rubocop.yml
# RSpec/VariableName:
#   EnforcedStyle: snake_case
#   AllowedPatterns:
#     - ^userFood# okay because it matches the `^userFood` regex in `AllowedPatterns`
subject(:userFood_1) { 'spaghetti' }
let(:userFood_2) { 'fettuccine' }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/VariableName)