
Checks for uses of `*` as a substitute for `Array#join`.
Using `join` is clearer about intent and more readable than
overloading the `*` operator for string conversion.

Not all cases can be reliably checked, due to Ruby's dynamic
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