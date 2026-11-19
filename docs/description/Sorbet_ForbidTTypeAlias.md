
Disallows using `T.type_alias` anywhere.
Set `AutocorrectToRBS: true` to replace standalone constant assignments with RBS type aliases.
Autocorrection is unsafe because it removes the Ruby constant. References to the
constant must be migrated separately to the lowercase RBS alias name.
Declarations containing RuboCop directives are not autocorrected.

# Examples

```ruby

# bad
STRING_OR_INTEGER = T.type_alias { T.any(Integer, String) }

# good
#: type string_or_integer = Integer | String
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTTypeAlias)