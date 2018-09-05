
This cop checks for use of the lambda.(args) syntax.

# Examples

```ruby
# bad
lambda.(x, y)

# good
lambda.call(x, y)# bad
lambda.call(x, y)

# good
lambda.(x, y)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/LambdaCall)