
Disallows using `T.cast` anywhere.

# Examples

```ruby

# bad
T.cast(foo, Integer)

# good
foo #: as Integer
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTCast)