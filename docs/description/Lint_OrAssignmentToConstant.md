
This cop checks for unintended or-assignment to a constant.

Constants should always be assigned in the same location. And its value
should always be the same. If constants are assigned in multiple
locations, the result may vary depending on the order of `require`.

# Examples

```ruby

# bad
CONST ||= 1

# good
CONST = 1
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/OrAssignmentToConstant)