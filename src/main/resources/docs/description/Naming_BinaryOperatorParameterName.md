
This cop makes sure that certain binary operator methods have their
sole  parameter named `other`.

# Examples

```ruby

# bad
def +(amount); end

# good
def +(other); end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/BinaryOperatorParameterName)