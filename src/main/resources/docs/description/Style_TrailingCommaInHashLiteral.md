
This cop checks for trailing comma in hash literals.

# Examples

```ruby
# bad
a = { foo: 1, bar: 2, }

# good
a = {
  foo: 1, bar: 2,
  qux: 3,
}

# good
a = {
  foo: 1,
  bar: 2,
}# bad
a = { foo: 1, bar: 2, }

# good
a = {
  foo: 1,
  bar: 2,
}# bad
a = { foo: 1, bar: 2, }

# good
a = {
  foo: 1,
  bar: 2
}
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TrailingCommaInHashLiteral)