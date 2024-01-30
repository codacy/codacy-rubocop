
Enforces the presence of parentheses in `super` containing arguments.

`super` is a keyword and is provided as a distinct cop from those designed for method call.

# Examples

```ruby

# bad
super name, age

# good
super(name, age)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SuperWithArgsParentheses)