
Checks that spec file paths suffix are consistent and well-formed.

# Examples

```ruby
# bad
my_class/foo_specorb.rb   # describe MyClass
spec/models/user.rb       # describe User
spec/models/user_specxrb  # describe User

# good
my_class_spec.rb          # describe MyClass

# good - shared examples are allowed
spec/models/user.rb       # shared_examples_for 'foo'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/SpecFilePathSuffix)