
Disallows using `T.absurd` anywhere.
Set `AutocorrectToRBS: true` to replace supported calls with RBS inline comments.

# Examples

```ruby

# bad
T.absurd(foo)

# good
foo #: absurd
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTAbsurd)