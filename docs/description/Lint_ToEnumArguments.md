
This cop ensures that `to_enum`/`enum_for`, called for the current method,
has correct arguments.

# Examples

```ruby
# bad
def foo(x, y = 1)
  return to_enum(__callee__, x) # `y` is missing
end

# good
def foo(x, y = 1)
  return to_enum(__callee__, x, y)
  # alternatives to `__callee__` are `__method__` and `:foo`
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/ToEnumArguments)