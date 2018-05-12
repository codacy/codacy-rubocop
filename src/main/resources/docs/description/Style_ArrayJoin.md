
This cop checks for uses of "*" as a substitute for *join*.

Not all cases can reliably checked, due to Ruby's dynamic
types, so we consider only cases when the first argument is an
array literal or the second is a string literal.

# Examples

```ruby

# bad
%w(foo bar baz) * ","

# good
%w(foo bar baz).join(",")
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ArrayJoin)