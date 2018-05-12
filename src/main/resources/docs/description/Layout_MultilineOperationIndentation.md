
This cop checks the indentation of the right hand side operand in
binary operations that span more than one line.

# Examples

```ruby
# bad
if a +
    b
  something
end

# good
if a +
   b
  something
end# bad
if a +
   b
  something
end

# good
if a +
    b
  something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/MultilineOperationIndentation)