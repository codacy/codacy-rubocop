
This cop checks for uses of *begin...end while/until something*.

# Examples

```ruby

# bad

# using while
begin
  do_something
end while some_condition
# bad

# using until
begin
  do_something
end until some_condition
# good

# using while
while some_condition
  do_something
end
# good

# using until
until some_condition
  do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/Loop)