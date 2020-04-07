
This cop checks for `raise` or `fail` statements which are
raising `Exception` class.

# Examples

```ruby
# bad
raise Exception, 'Error message here'

# good
raise StandardError, 'Error message here'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/RaiseException)