
Checks for RuntimeError as the argument of raise/fail.

# Examples

```ruby
# bad
raise RuntimeError, 'message'
raise RuntimeError.new('message')

# good
raise 'message'

# bad - message is not a string
raise RuntimeError, Object.new
raise RuntimeError.new(Object.new)

# good
raise Object.new.to_s
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantException)