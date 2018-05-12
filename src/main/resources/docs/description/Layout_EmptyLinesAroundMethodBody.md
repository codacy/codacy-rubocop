
This cops checks if empty lines exist around the bodies of methods.

# Examples

```ruby

# good

def foo
  # ...
end

# bad

def bar

  # ...

end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyLinesAroundMethodBody)