
This cop checks for `:true` and `:false` symbols.
In most cases it would be a typo.

# Examples

```ruby

# bad
:true

# good
true
# bad
:false

# good
false
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/BooleanSymbol)