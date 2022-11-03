
Checks for spaces between `->` and opening parameter
parenthesis (`(`) in lambda literals.

# Examples

```ruby
# bad
a = -> (x, y) { x + y }

# good
a = ->(x, y) { x + y }# bad
a = ->(x, y) { x + y }

# good
a = -> (x, y) { x + y }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceInLambdaLiteral)