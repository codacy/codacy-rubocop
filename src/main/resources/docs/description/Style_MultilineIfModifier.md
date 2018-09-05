
Checks for uses of if/unless modifiers with multiple-lines bodies.

# Examples

```ruby

# bad
{
  result: 'this should not happen'
} unless cond

# good
{ result: 'ok' } if cond
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MultilineIfModifier)