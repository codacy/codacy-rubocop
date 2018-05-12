
Checks for comma (,) not followed by some kind of space.

# Examples

```ruby

# bad
[1,2]
{ foo:bar,}

# good
[1, 2]
{ foo:bar, }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceAfterComma)