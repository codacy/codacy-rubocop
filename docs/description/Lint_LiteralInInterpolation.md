
This cop checks for interpolated literals.

# Examples

```ruby

# bad

"result is #{10}"
# good

"result is 10"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/LiteralInInterpolation)