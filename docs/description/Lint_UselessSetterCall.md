
This cop checks for setter call to local variable as the final
expression of a function definition.

# Examples

```ruby

# bad

def something
  x = Something.new
  x.attr = 5
end
# good

def something
  x = Something.new
  x.attr = 5
  x
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UselessSetterCall)