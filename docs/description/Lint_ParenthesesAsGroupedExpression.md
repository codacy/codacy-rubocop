
Checks for space between the name of a called method and a left
parenthesis.

# Examples

```ruby

# bad
do_something (foo)

# good
do_something(foo)
do_something (2 + 3) * 4
do_something (foo * bar).baz
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/ParenthesesAsGroupedExpression)