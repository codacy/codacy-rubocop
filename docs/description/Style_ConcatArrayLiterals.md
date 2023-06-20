
Enforces the use of `Array#push(item)` instead of `Array#concat([item])`
to avoid redundant array literals.

# Examples

```ruby

# bad
list.concat([foo])
list.concat([bar, baz])
list.concat([qux, quux], [corge])

# good
list.push(foo)
list.push(bar, baz)
list.push(qux, quux, corge)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ConcatArrayLiterals)