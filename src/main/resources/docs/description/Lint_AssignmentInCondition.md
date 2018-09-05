
This cop checks for assignments in the conditions of
if/while/until.

# Examples

```ruby

# bad

if some_var = true
  do_something
end
# good

if some_var == true
  do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/AssignmentInCondition)