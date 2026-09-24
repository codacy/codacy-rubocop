
Disallows using `T.must` anywhere.
Set `AutocorrectToRBS: true` to replace supported calls with RBS inline comments.

# Examples

```ruby

# bad
T.must(foo)

# good
foo #: as !nil
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTMust)