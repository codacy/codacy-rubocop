
Checks for assignments in the conditions of
if/while/until.

`AllowSafeAssignment` option for safe assignment.
By safe assignment we mean putting parentheses around
an assignment to indicate "I know I'm using an assignment
as a condition. It's not a mistake."

# Examples

```ruby
# bad
if some_var = value
  do_something
end

# good
if some_var == value
  do_something
end# good
if (some_var = value)
  do_something
end# bad
if (some_var = value)
  do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/AssignmentInCondition)