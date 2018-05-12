
This cop checks for strings that are just an interpolated expression.

# Examples

```ruby

# bad
"#{@var}"

# good
@var.to_s

# good if @var is already a String
@var
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/UnneededInterpolation)