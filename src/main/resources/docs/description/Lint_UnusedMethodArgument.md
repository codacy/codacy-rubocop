
This cop checks for unused method arguments.

# Examples

```ruby

# bad

def some_method(used, unused, _unused_but_allowed)
  puts used
end
# good

def some_method(used, _unused, _unused_but_allowed)
  puts used
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UnusedMethodArgument)