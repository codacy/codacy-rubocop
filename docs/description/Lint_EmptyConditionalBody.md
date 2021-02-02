
This cop checks for the presence of `if`, `elsif` and `unless` branches without a body.

# Examples

```ruby
# bad
if condition
end

# bad
unless condition
end

# bad
if condition
  do_something
elsif other_condition
end

# good
if condition
  do_something
end

# good
unless condition
  do_something
end

# good
if condition
  do_something
elsif other_condition
  do_something_else
end# good
if condition
  do_something
elsif other_condition
  # noop
end# bad
if condition
  do_something
elsif other_condition
  # noop
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/EmptyConditionalBody)