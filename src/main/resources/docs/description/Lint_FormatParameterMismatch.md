
This lint sees if there is a mismatch between the number of
expected fields for format/sprintf/#% and what is actually
passed as arguments.

# Examples

```ruby

# bad

format('A value: %s and another: %i', a_value)
# good

format('A value: %s and another: %i', a_value, another)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/FormatParameterMismatch)