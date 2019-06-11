
This cop checks the indentation of the first parameter in a method call.
Parameters after the first one are checked by Layout/AlignParameters,
not by this cop.

# Examples

```ruby

# bad
def some_method(
first_param,
second_param)
  123
end# The first parameter should always be indented one step more than the
# preceding line.

# good
def some_method(
  first_param,
second_param)
  123
end# The first parameter should always be indented one step more than the
# opening parenthesis.

# good
def some_method(
                 first_param,
second_param)
  123
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/IndentFirstParameter)