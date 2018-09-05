
This cops checks if empty lines exist around the bodies of begin-end
blocks.

# Examples

```ruby

# good

begin
  # ...
end

# bad

begin

  # ...

end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyLinesAroundBeginBody)