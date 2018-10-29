
This cop checks for *return* from an *ensure* block.
Explicit return from an ensure block alters the control flow
as the return will take precedence over any exception being raised,
and the exception will be silently thrown away as if it were rescued.

# Examples

```ruby

# bad

begin
  do_something
ensure
  do_something_else
  return
end
# good

begin
  do_something
ensure
  do_something_else
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/EnsureReturn)