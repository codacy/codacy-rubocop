
This cop checks for redundant parentheses.

# Examples

```ruby

# bad
(x) if ((y.z).nil?)

# good
x if y.z.nil?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantParentheses)