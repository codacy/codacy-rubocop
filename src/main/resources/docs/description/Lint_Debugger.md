
This cop checks for calls to debugger or pry.

# Examples

```ruby

# bad (ok during development)

# using pry
def some_method
  binding.pry
  do_something
end
# bad (ok during development)

# using byebug
def some_method
  byebug
  do_something
end
# good

def some_method
  do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/Debugger)