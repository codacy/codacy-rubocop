
Checks for unreachable code.
The check are based on the presence of flow of control
statement in non-final position in `begin` (implicit) blocks.

# Examples

```ruby

# bad
def some_method
  return
  do_something
end

# bad
def some_method
  if cond
    return
  else
    return
  end
  do_something
end

# good
def some_method
  do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UnreachableCode)