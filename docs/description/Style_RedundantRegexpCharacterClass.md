
Checks for unnecessary single-element Regexp character classes.

# Examples

```ruby

# bad
r = /[x]/

# good
r = /x/

# bad
r = /[\s]/

# good
r = /\s/

# bad
r = %r{/[b]}

# good
r = %r{/b}

# good
r = /[ab]/
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantRegexpCharacterClass)