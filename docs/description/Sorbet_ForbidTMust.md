
Disallows using `T.must` anywhere.

# Examples

```ruby

# bad
T.must(foo)

# good
foo #: as !nil
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTMust)