
This cop warns the usage of unsafe number conversions. Unsafe
number conversion can cause unexpected error if auto type conversion
fails. Cop prefer parsing with number class instead.

# Examples

```ruby

# bad

'10'.to_i
'10.2'.to_f
'10'.to_c

# good

Integer('10', 10)
Float('10.2')
Complex('10')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/NumberConversion)