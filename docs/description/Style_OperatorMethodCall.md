
Checks for redundant dot before operator method call.
The target operator methods are `|`, `^`, `&`, ``<=>``, `==`, `===`, `=~`, `>`, `>=`, `<`,
``<=``, `<<`, `>>`, `+`, `-`, `*`, `/`, `%`, `**`, `~`, `!`, `!=`, and `!~`.

# Examples

```ruby

# bad
foo.+ bar
foo.& bar

# good
foo + bar
foo & bar
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/OperatorMethodCall)