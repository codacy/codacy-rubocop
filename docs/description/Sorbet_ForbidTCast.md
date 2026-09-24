
Disallows using `T.cast` anywhere.
Set `AutocorrectToRBS: true` to replace supported calls with RBS inline comments.

# Examples

```ruby

# bad
T.cast(foo, Integer)

# good
foo #: as Integer
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTCast)