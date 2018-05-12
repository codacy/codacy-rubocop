
This cop checks for *rescue* blocks targeting the Exception class.

# Examples

```ruby

# bad

begin
  do_something
rescue Exception
  handle_exception
end
# good

begin
  do_something
rescue ArgumentError
  handle_exception
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/RescueException)