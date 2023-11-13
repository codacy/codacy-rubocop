
Enforces consistency between `return nil` and `return`.

This cop is disabled by default. Because there seems to be a perceived semantic difference
between `return` and `return nil`. The former can be seen as just halting evaluation,
while the latter might be used when the return value is of specific concern.

Supported styles are `return` and `return_nil`.

# Examples

```ruby
# bad
def foo(arg)
  return nil if arg
end

# good
def foo(arg)
  return if arg
end# bad
def foo(arg)
  return if arg
end

# good
def foo(arg)
  return nil if arg
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ReturnNil)