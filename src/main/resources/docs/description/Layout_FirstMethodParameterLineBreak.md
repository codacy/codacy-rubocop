
This cop checks for a line break before the first parameter in a
multi-line method parameter definition.

# Examples

```ruby

# bad
def method(foo, bar,
    baz)
  do_something
end

# good
def method(
    foo, bar,
    baz)
  do_something
end

# ignored
def method foo,
    bar
  do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/FirstMethodParameterLineBreak)