
Checks for uses of `do` in multi-line `while/until` statements.

# Examples

```ruby

# bad
while x.any? do
  do_something(x.pop)
end

# good
while x.any?
  do_something(x.pop)
end
# bad
until x.empty? do
  do_something(x.pop)
end

# good
until x.empty?
  do_something(x.pop)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/WhileUntilDo)