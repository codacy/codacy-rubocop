
Detect and autocorrect `T.any(..., NilClass, ...)` to `T.nilable(...)`

# Examples

```ruby

# bad
T.any(String, NilClass)
T.any(NilClass, String)
T.any(NilClass, Symbol, String)

# good
T.nilable(String)
T.nilable(String)
T.nilable(T.any(Symbol, String))
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTAnyWithNil)