
This cop checks that the indentation method is consistent.
Either tabs only or spaces only are used for indentation.

# Examples

```ruby
# bad
# This example uses a tab to indent bar.
def foo
  bar
end

# good
# This example uses spaces to indent bar.
def foo
  bar
end# bad
# This example uses spaces to indent bar.
def foo
  bar
end

# good
# This example uses a tab to indent bar.
def foo
  bar
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/IndentationStyle)