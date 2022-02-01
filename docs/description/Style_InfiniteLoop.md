
Use `Kernel#loop` for infinite loops.

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