
This cop checks for division with integers coerced to floats.
It is recommended to either always use `fdiv` or coerce one side only.
This cop also provides other options for code consistency.

# Examples

```ruby
# bad
a.to_f / b.to_f

# good
a.to_f / b
a / b.to_f# bad
a / b.to_f
a.to_f / b.to_f

# good
a.to_f / b# bad
a.to_f / b
a.to_f / b.to_f

# good
a / b.to_f# bad
a / b.to_f
a.to_f / b
a.to_f / b.to_f

# good
a.fdiv(b)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/FloatDivision)