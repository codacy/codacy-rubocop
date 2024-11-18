
Prefer bitwise predicate methods over direct comparison operations.

# Examples

```ruby

# bad - checks any set bits
(variable & flags).positive?

# good
variable.anybits?(flags)

# bad - checks all set bits
(variable & flags) == flags

# good
variable.allbits?(flags)

# bad - checks no set bits
(variable & flags).zero?

# good
variable.nobits?(flags)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/BitwisePredicate)