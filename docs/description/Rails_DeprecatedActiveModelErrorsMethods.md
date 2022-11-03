
Checks direct manipulation of ActiveModel#errors as hash.
These operations are deprecated in Rails 6.1 and will not work in Rails 7.

# Examples

```ruby
# bad
user.errors[:name] << 'msg'
user.errors.messages[:name] << 'msg'

# good
user.errors.add(:name, 'msg')

# bad
user.errors[:name].clear
user.errors.messages[:name].clear

# good
user.errors.delete(:name)

# bad
user.errors.keys.include?(:attr)

# good
user.errors.attribute_names.include?(:attr)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/DeprecatedActiveModelErrorsMethods)