
Disallows using `T.unsafe` anywhere.

# Examples

```ruby

# bad
T.unsafe(foo)

# good
foo
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTUnsafe)