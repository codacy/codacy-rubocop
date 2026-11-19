
Checks that the indentation method is consistent.
Either tabs only or spaces only are used for indentation.

With `EnforcedStyle: tabs`, spaces that follow the indenting tabs are
taken to be alignment rather than indentation, and are left alone.

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
end

# bad
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