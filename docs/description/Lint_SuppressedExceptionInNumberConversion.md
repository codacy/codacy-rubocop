
Checks for cases where exceptions unrelated to the numeric constructors `Integer()`,
`Float()`, `BigDecimal()`, `Complex()`, and `Rational()` may be unintentionally swallowed.

# Examples

```ruby

# bad
Integer(arg) rescue nil

# bad
begin
  Integer(arg)
rescue
  nil
end

# bad
begin
  Integer(arg)
rescue
end

# good
Integer(arg, exception: false)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/SuppressedExceptionInNumberConversion)