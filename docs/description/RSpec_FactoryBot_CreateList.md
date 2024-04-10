
Checks for create_list usage.

This cop can be configured using the `EnforcedStyle` option

# Examples

```ruby
# bad
3.times { create :user }

# good
create_list :user, 3

# bad
3.times { create :user, age: 18 }

# good - index is used to alter the created models attributes
3.times { |n| create :user, age: n }

# good - contains a method call, may return different values
3.times { create :user, age: rand }# bad
create_list :user, 3

# good
3.times { create :user }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/FactoryBot/CreateList)