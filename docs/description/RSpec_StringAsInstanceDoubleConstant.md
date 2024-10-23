
Do not use a string as `instance_double` constant.

# Examples

```ruby
# bad
instance_double('User', name: 'John')

# good
instance_double(User, name: 'John')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/StringAsInstanceDoubleConstant)