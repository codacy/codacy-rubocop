
Checks for quotes and commas in %w, e.g. `%w('foo', "bar")`

It is more likely that the additional characters are unintended (for
example, mistranslating an array of literals to percent string notation)
rather than meant to be part of the resulting strings.

When a quoted string contains whitespace, `%w` splits it into separate values,
so removing the quotes would not restore the intended string.
Such an array is corrected to an array literal instead, as long as its content
reads as one with only string elements.

# Examples

```ruby

# bad
%w('foo', "bar")

# good
%w(foo bar)

# bad - the quoted strings are split at whitespace
%w('foo bar', 'baz')

# good
['foo bar', 'baz']
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/PercentStringArray)