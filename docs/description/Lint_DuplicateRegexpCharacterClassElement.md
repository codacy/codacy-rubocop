
Checks for duplicate elements in `Regexp` character classes.

# Examples

```ruby

# bad
r = /[xyx]/

# bad
r = /[0-9x0-9]/

# good
r = /[xy]/

# good
r = /[0-9x]/
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DuplicateRegexpCharacterClassElement)