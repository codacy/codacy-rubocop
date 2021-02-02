
This cop checks that there are no repeated exceptions
used in 'rescue' expressions.

# Examples

```ruby
# bad
begin
  something
rescue FirstException
  handle_exception
rescue FirstException
  handle_other_exception
end

# good
begin
  something
rescue FirstException
  handle_exception
rescue SecondException
  handle_other_exception
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DuplicateRescueException)