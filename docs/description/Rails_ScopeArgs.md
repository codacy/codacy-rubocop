
This cop checks for scope calls where it was passed
a method (usually a scope) instead of a lambda/proc.

# Examples

```ruby

# bad
scope :something, where(something: true)

# good
scope :something, -> { where(something: true) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ScopeArgs)