
This cop checks for the presence of `in` pattern branches without a body.

# Examples

```ruby

# bad
case condition
in [a]
  do_something
in [a, b]
end

# good
case condition
in [a]
  do_something
in [a, b]
  nil
end
# good
case condition
in [a]
  do_something
in [a, b]
  # noop
end
# bad
case condition
in [a]
  do_something
in [a, b]
  # noop
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/EmptyInPattern)