
This cop checks for unparenthesized method calls in the argument list
of a parenthesized method call.

# Examples

```ruby
# good
method1(method2(arg), method3(arg))

# bad
method1(method2 arg, method3, arg)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NestedParenthesizedCalls)