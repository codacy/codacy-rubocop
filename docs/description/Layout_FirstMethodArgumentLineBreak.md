
Checks for a line break before the first argument in a
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
# bad
method(foo, bar, {
  baz: "a",
  qux: "b",
})

# good
method(
  foo, bar, {
  baz: "a",
  qux: "b",
})
# bad
method(foo,
  bar,
  {
    baz: "a",
    qux: "b",
  }
)

# good
method(foo, bar, {
  baz: "a",
  qux: "b",
})

# good
method(
  foo,
  bar,
  {
    baz: "a",
    qux: "b",
  }
)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/FirstMethodArgumentLineBreak)