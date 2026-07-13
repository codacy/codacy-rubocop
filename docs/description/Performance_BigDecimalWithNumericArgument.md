
Identifies places where a float argument to BigDecimal should be converted to a string.
Initializing from String is faster than from Float for BigDecimal.

Also identifies places where an integer string argument to BigDecimal should be converted to
an integer. Initializing from Integer is faster than from String for BigDecimal.

NOTE: This cop is disabled by default because the performance of initializing with a String
and Number differ between versions. Additionally, performance depends on the size of the Number,
and if it is an Integer or a Float. Since this is very specific to `bigdecimal` internals,
suggestions from this cop are not unlikely to result in code that performs worse than before.

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