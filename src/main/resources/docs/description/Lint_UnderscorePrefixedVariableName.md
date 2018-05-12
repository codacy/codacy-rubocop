
This cop checks for underscore-prefixed variables that are actually
used.

# Examples

```ruby

# bad

[1, 2, 3].each do |_num|
  do_something(_num)
end
# good

[1, 2, 3].each do |num|
  do_something(num)
end
# good

[1, 2, 3].each do |_num|
  do_something # not using `_num`
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UnderscorePrefixedVariableName)