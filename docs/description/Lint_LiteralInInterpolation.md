
Checks for interpolated literals.

NOTE: Array literals interpolated in regexps are not handled by this cop, but
by `Lint/ArrayLiteralInRegexp` instead.

# Examples

```ruby

# bad
"result is #{10}"

# good
"result is 10"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/LiteralInInterpolation)