
This cop checks for the presence of empty expressions.

# Examples

```ruby

# bad

foo = ()
if ()
  bar
end
# good

foo = (some_expression)
if (some_expression)
  bar
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/EmptyExpression)