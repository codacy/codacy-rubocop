
This cop checks for RuntimeError as the argument of raise/fail.

It checks for code like this:

# Examples

```ruby
# Bad
raise RuntimeError, 'message'

# Bad
raise RuntimeError.new('message')

# Good
raise 'message'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantException)