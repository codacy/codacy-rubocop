
If the `else` branch of a conditional consists solely of an `if` node,
it can be combined with the `else` to become an `elsif`.
This helps to keep the nesting level from getting too deep.

# Examples

```ruby
# bad
if condition_a
  action_a
else
  if condition_b
    action_b
  else
    action_c
  end
end

# good
if condition_a
  action_a
elsif condition_b
  action_b
else
  action_c
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/IfInsideElse)