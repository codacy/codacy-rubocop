
This cop makes sure that all numbered variables use the
configured style, snake_case, normalcase or non_integer,
for their numbering.

# Examples

```ruby
# bad

variable1 = 1

# good

variable_1 = 1# bad

variable_1 = 1

# good

variable1 = 1# bad

variable1 = 1

variable_1 = 1

# good

variableone = 1

variable_one = 1
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/VariableNumber)