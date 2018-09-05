
This cop checks whether the rescue and ensure keywords are aligned
properly.

# Examples

```ruby

# bad
begin
  something
  rescue
  puts 'error'
end

# good
begin
  something
rescue
  puts 'error'
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/RescueEnsureAlignment)