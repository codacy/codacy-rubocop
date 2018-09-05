
This cop checks for parentheses for empty lambda parameters. Parentheses
for empty lambda parameters do not cause syntax errors, but they are
redundant.

# Examples

```ruby
# bad
-> () { do_something }

# good
-> { do_something }

# good
-> (arg) { do_something(arg) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EmptyLambdaParameter)