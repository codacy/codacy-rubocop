
This cop checks for *return* from an *ensure* block.

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