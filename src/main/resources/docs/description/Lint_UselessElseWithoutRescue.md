
This cop checks for useless `else` in `begin..end` without `rescue`.

# Examples

```ruby

# bad

begin
  do_something
else
  do_something_else # This will never be run.
end
# good

begin
  do_something
rescue
  handle_errors
else
  do_something_else
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UselessElseWithoutRescue)