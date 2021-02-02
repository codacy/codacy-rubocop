
This cop ensures that each argument in a multi-line method call
starts on a separate line.

# Examples

```ruby

# bad
foo(a, b,
  c
)

# good
foo(
  a,
  b,
  c
)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/MultilineMethodArgumentLineBreaks)