
If the branch of a conditional consists solely of a conditional node,
its conditions can be combined with the conditions of the outer branch.
This helps to keep the nesting level from getting too deep.

# Examples

```ruby
# bad
if condition_a
  if condition_b
    do_something
  end
end

# good
if condition_a && condition_b
  do_something
end# bad
if condition_a
  do_something if condition_b
end# good
if condition_a
  do_something if condition_b
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SoleNestedConditional)