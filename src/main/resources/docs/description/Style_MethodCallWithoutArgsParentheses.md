
This cop checks for unwanted parentheses in parameterless method calls.

# Examples

```ruby
# bad
object.some_method()

# good
object.some_method
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MethodCallWithoutArgsParentheses)