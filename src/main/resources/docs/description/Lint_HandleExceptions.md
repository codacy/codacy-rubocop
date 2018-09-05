
This cop checks for *rescue* blocks with no body.

# Examples

```ruby

# bad

def some_method
  do_something
rescue
  # do nothing
end
# bad

begin
  do_something
rescue
  # do nothing
end
# good

def some_method
  do_something
rescue
  handle_exception
end
# good

begin
  do_something
rescue
  handle_exception
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/HandleExceptions)