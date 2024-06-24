
Checks for create_list usage.

This cop can be configured using the `EnforcedStyle` option

# Examples

```ruby
# bad
3.times { create :user }
3.times.map { create :user }
[create(:user), create(:user), create(:user)]
Array.new(3) { create :user }

# good
create_list :user, 3

# bad
3.times { create :user, age: 18 }

# good - index is used to alter the created models attributes
3.times { |n| create :user, age: n }

# good - contains a method call, may return different values
3.times { create :user, age: rand }# bad
create_list :user, 3
[create(:user), create(:user), create(:user)]

# good
3.times.map { create :user }
# bad - with `EnforcedStyle: create_list`
3.times { FactoryBot.create :user }
3.times { create :user }

# good - with `EnforcedStyle: create_list`
FactoryBot.create_list :user, 3
create_list :user, 3
# bad - with `EnforcedStyle: create_list`
3.times { FactoryBot.create :user }

# good - with `EnforcedStyle: create_list`
FactoryBot.create_list :user, 3
create_list :user, 3
3.times { create :user }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/FactoryBot/CreateList)