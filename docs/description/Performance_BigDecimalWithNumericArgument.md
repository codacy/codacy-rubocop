
Identifies places where a float argument to BigDecimal should be converted to a string.
Initializing from String is faster than from Float for BigDecimal.

Also identifies places where an integer string argument to BigDecimal should be converted to
an integer. Initializing from Integer is faster than from String for BigDecimal.

# Examples

```ruby
# bad
BigDecimal(1.2, 3, exception: true)
4.5.to_d(6, exception: true)

# good
BigDecimal('1.2', 3, exception: true)
BigDecimal('4.5', 6, exception: true)

# bad
BigDecimal('1', 2)
BigDecimal('4', 6)

# good
BigDecimal(1, 2)
4.to_d(6)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/BigDecimalWithNumericArgument)