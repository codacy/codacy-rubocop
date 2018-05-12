
This cop checks for `raise` or `fail` statements which do not specify an
explicit exception class. (This raises a `RuntimeError`. Some projects
might prefer to use exception classes which more precisely identify the
nature of the error.)

# Examples

```ruby
# bad
raise 'Error message here'

# good
raise ArgumentError, 'Error message here'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ImplicitRuntimeError)