
This cop identifies places where numeric argument to BigDecimal should be
converted to string. Initializing from String is faster
than from Numeric for BigDecimal.

# Examples

```ruby
# bad
BigDecimal(1, 2)
4.to_d(6)
BigDecimal(1.2, 3, exception: true)
4.5.to_d(6, exception: true)

# good
BigDecimal('1', 2)
BigDecimal('4', 6)
BigDecimal('1.2', 3, exception: true)
BigDecimal('4.5', 6, exception: true)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/BigDecimalWithNumericArgument)