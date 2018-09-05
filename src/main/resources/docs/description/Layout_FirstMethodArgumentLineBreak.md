
This cop checks for a line break before the first argument in a
multi-line method call.

# Examples

```ruby

# bad
method(foo, bar,
  baz)

# good
method(
  foo, bar,
  baz)

# ignored
method foo, bar,
  baz
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/FirstMethodArgumentLineBreak)