
`BigDecimal.new()` is deprecated since BigDecimal 1.3.3.
This cop identifies places where `BigDecimal.new()`
can be replaced by `BigDecimal()`.

# Examples

```ruby
# bad
BigDecimal.new(123.456, 3)

# good
BigDecimal(123.456, 3)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/BigDecimalNew)