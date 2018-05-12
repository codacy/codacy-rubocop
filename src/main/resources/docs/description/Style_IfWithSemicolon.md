
Checks for uses of semicolon in if statements.

# Examples

```ruby

# bad
result = if some_condition; something else another_thing end

# good
result = some_condition ? something : another_thing
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/IfWithSemicolon)