
Use `Kernel#loop` for infinite loops.

This cop is marked as unsafe as the rule does not necessarily
apply if the body might raise a `StopIteration` exception; contrary to
other infinite loops, `Kernel#loop` silently rescues that and returns `nil`.

# Examples

```ruby
# bad
while true
  work
end

# good
loop do
  work
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/InfiniteLoop)