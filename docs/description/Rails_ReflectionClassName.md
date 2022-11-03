
Checks if the value of the option `class_name`, in
the definition of a reflection is a string.

# Examples

```ruby
# bad
has_many :accounts, class_name: Account
has_many :accounts, class_name: Account.name

# good
has_many :accounts, class_name: 'Account'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ReflectionClassName)