
Checks for mixed-case character ranges since they include likely unintended characters.

Offenses are registered for regexp character classes like `/[A-z]/`
as well as range objects like `('A'..'z')`.

NOTE: `Range` objects cannot be autocorrected.

# Examples

```ruby

# bad
r = /[A-z]/

# good
r = /[A-Za-z]/
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/MixedCaseRange)