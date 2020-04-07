
This cop checks for trailing comma in hash literals.
The configuration options are:

- `consistent_comma`: Requires a comma after the
last item of all non-empty, multiline hash literals.
- `comma`: Requires a comma after the last item in a hash,
but only when each item is on its own line.
- `no_comma`: Does not requires a comma after the
last item in a hash

# Examples

```ruby

# bad
a = { foo: 1, bar: 2, }

# good
a = { foo: 1, bar: 2 }

# good
a = {
  foo: 1, bar: 2,
  qux: 3,
}

# good
a = {
  foo: 1, bar: 2, qux: 3,
}

# good
a = {
  foo: 1,
  bar: 2,
}
# bad
a = { foo: 1, bar: 2, }

# good
a = { foo: 1, bar: 2 }

# bad
a = {
  foo: 1, bar: 2,
  qux: 3,
}

# good
a = {
  foo: 1, bar: 2,
  qux: 3
}

# bad
a = {
  foo: 1, bar: 2, qux: 3,
}

# good
a = {
  foo: 1, bar: 2, qux: 3
}

# good
a = {
  foo: 1,
  bar: 2,
}
# bad
a = { foo: 1, bar: 2, }

# good
a = {
  foo: 1,
  bar: 2
}
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TrailingCommaInHashLiteral)