
Checks whether the multiline assignments have a newline
after the assignment operator.

# Examples

```ruby
# bad
foo = if expression
  'bar'
end

# good
foo =
  if expression
    'bar'
  end

# good
foo =
  begin
    compute
  rescue => e
    nil
  end# good
foo = if expression
  'bar'
end# good
foo =
  if expression
    'bar'
  end

# good
foo =
  [1].map do |i|
    i + 1
  end# good
foo = if expression
  'bar'
end

# good
foo =
  [1].map do |i|
    'bar' * i
  end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/MultilineAssignmentLayout)