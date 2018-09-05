
This cop checks for colons and commas in %i, e.g. `%i(:foo, :bar)`

It is more likely that the additional characters are unintended (for
example, mistranslating an array of literals to percent string notation)
rather than meant to be part of the resulting symbols.

# Examples

```ruby

# bad

%i(:foo, :bar)
# good

%i(foo bar)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/PercentSymbolArray)