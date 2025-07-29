
Disallows using `T.type_alias` anywhere.

# Examples

```ruby

# bad
STRING_OR_INTEGER = T.type_alias { T.any(Integer, String) }

# good
#: type string_or_integer = Integer | String
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTTypeAlias)