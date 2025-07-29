
Disallows using `T.let` anywhere.

# Examples

```ruby

# bad
T.let(foo, Integer)

# good
foo #: Integer
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTLet)