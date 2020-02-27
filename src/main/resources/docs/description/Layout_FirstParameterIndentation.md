
This cop checks the indentation of the first parameter in a method
definition. Parameters after the first one are checked by
Layout/ParameterAlignment, not by this cop.

For indenting the first argument of method *calls*, check out
Layout/FirstArgumentIndentation, which supports options related to
nesting that are irrelevant for method *definitions*.

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

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/FirstParameterIndentation)