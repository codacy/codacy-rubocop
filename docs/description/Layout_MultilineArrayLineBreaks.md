
Ensures that each item in a multi-line array
starts on a separate line.

# Examples

```ruby

# bad
[
  a, b,
  c
]

# good
[
  a,
  b,
  c
]

# good
[
  a,
  b,
  foo(
    bar
  )
]
# bad
[a, b, foo(
  bar
)]
# good
[a, b, foo(
  bar
)]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/MultilineArrayLineBreaks)