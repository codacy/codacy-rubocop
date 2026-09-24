
Disallows assigning the result of `T.bind`.

`T.bind` changes the type of its first argument and returns that argument.
Assigning its result can therefore unintentionally change the inferred type
of both the assignment target and the first argument.

# Examples

```ruby

# bad
foo = T.bind(self, Integer)

# good
foo = T.cast(self, Integer)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTBindInAssignment)