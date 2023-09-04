
Disallows the usage of `checked(true)`. This usage could cause
confusion; it could lead some people to believe that a method would be checked
even if runtime checks have not been enabled on the class or globally.
Additionally, in the event where checks are enabled, `checked(true)` would
be redundant; only `checked(false)` or `soft` would change the behaviour.

# Examples

```ruby

# bad
sig { void.checked(true) }

# good
sig { void }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/CheckedTrueInSignature)