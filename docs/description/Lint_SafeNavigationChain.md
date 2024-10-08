
The safe navigation operator returns nil if the receiver is
nil. If you chain an ordinary method call after a safe
navigation operator, it raises NoMethodError. We should use a
safe navigation operator after a safe navigation operator.
This cop checks for the problem outlined above.

# Examples

```ruby

# bad
x&.foo.bar
x&.foo + bar
x&.foo[bar]

# good
x&.foo&.bar
x&.foo || bar
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/SafeNavigationChain)