
This cop checks for uses of rescue in its modifier form.

# Examples

```ruby
# bad
some_method rescue handle_error

# good
begin
  some_method
rescue
  handle_error
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RescueModifier)