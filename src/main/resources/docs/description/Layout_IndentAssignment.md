
This cop checks the indentation of the first line of the
right-hand-side of a multi-line assignment.

The indentation of the remaining lines can be corrected with
other cops such as `IndentationConsistency` and `EndAlignment`.

# Examples

```ruby
# bad
value =
if foo
  'bar'
end

# good
value =
  if foo
    'bar'
  end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/IndentAssignment)