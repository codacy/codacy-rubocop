
This cop checks for uses of `begin...end while/until something`.

The cop is marked as unsafe because behaviour can change in some cases, including
if a local variable inside the loop body is accessed outside of it, or if the
loop body raises a `StopIteration` exception (which `Kernel#loop` rescues).

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

# while replacement
loop do
  do_something
  break unless some_condition
end
# good

# until replacement
loop do
  do_something
  break if some_condition
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/Loop)