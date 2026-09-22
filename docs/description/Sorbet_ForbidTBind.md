
Disallows using `T.bind` anywhere.
Set `AutocorrectToRBS: true` to replace supported calls with RBS inline comments.

# Examples

```ruby

# bad
T.bind(self, Integer)

# good
#: self as Integer
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTBind)