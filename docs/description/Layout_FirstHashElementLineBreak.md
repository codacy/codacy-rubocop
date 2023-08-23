
Checks for a line break before the first element in a
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

# good
{
  a: 1, b: {
  c: 3
}}
# bad
{ a: 1, b: {
  c: 3
}}
# bad
{ a: 1,
  b: {
  c: 3
}}

# good
{ a: 1, b: {
  c: 3
}}
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/FirstHashElementLineBreak)