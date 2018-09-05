
This cop checks for conditions that are not on the same line as
if/while/until.

# Examples

```ruby

# bad

if
  some_condition
  do_something
end
# good

if some_condition
  do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/ConditionPosition)