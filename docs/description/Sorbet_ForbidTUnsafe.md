
Disallows using `T.unsafe` anywhere.
Set `AutocorrectToRBS: true` to replace supported calls with RBS inline comments.

# Examples

```ruby

# bad
T.unsafe(foo)

# good
foo #: as untyped
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTUnsafe)