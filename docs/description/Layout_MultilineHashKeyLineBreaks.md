
Ensures that each key in a multi-line hash
starts on a separate line.

# Examples

```ruby

# bad
{
  a: 1, b: 2,
  c: 3
}

# good
{
  a: 1,
  b: 2,
  c: 3
}

# good
{
  a: 1,
  b: {
    c: 3,
  }
}
# bad
{ a: 1, b: {
  c: 3,
}}
# good
{ a: 1, b: {
  c: 3,
}}
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/MultilineHashKeyLineBreaks)