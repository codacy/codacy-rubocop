
This cop checks for nested ternary op expressions.

# Examples

```ruby
# bad
a ? (b ? b1 : b2) : a2

# good
if a
  b ? b1 : b2
else
  a2
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NestedTernaryOperator)