
This cop checks for odd else block layout - like
having an expression on the same line as the else keyword,
which is usually a mistake.

# Examples

```ruby

# bad

if something
  # ...
else do_this
  do_that
end
# good

if something
  # ...
else
  do_this
  do_that
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/ElseLayout)