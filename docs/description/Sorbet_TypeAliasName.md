
Ensures all constants used as `T.type_alias` are using CamelCase.

# Examples

```ruby

# bad
FOO_OR_BAR = T.type_alias { T.any(Foo, Bar) }

# good
FooOrBar = T.type_alias { T.any(Foo, Bar) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/TypeAliasName)