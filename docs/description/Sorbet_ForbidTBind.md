
Disallows using `T.bind` anywhere.

# Examples

```ruby

# bad
T.bind(self, Integer)

# good
#: self as Integer
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTBind)