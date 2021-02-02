
This cop checks for a line break before the first element in a
multi-line hash.

# Examples

```ruby

# bad
{ a: 1,
  b: 2}

# good
{
  a: 1,
  b: 2 }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/FirstHashElementLineBreak)