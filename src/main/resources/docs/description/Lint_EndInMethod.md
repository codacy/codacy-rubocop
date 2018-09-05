
This cop checks for END blocks in method definitions.

# Examples

```ruby

# bad

def some_method
  END { do_something }
end
# good

def some_method
  at_exit { do_something }
end
# good

# outside defs
END { do_something }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/EndInMethod)