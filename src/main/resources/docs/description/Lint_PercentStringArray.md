
This cop checks for quotes and commas in %w, e.g. `%w('foo', "bar")`

It is more likely that the additional characters are unintended (for
example, mistranslating an array of literals to percent string notation)
rather than meant to be part of the resulting strings.

# Examples

```ruby

# bad

%w('foo', "bar")
# good

%w(foo bar)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/PercentStringArray)