
This cop checks for multi-line ternary op expressions.

# Examples

```ruby
# bad
a = cond ?
  b : c
a = cond ? b :
    c
a = cond ?
    b :
    c

# good
a = cond ? b : c
a =
  if cond
    b
  else
    c
  end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MultilineTernaryOperator)