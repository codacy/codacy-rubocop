
Checks for redundant dot before operator method call.
The target operator methods are `|`, `^`, `&`, ``<=>``, `==`, `===`, `=~`, `>`, `>=`, `<`,
``<=``, `<<`, `>>`, `+`, `-`, `*`, `/`, `%`, `**`, `!=`, and `!~`.

`!` and `~` are not targeted because they have no binary operator form,
so `foo.! bar` cannot be written as `foo ! bar`, which means `foo(!bar)`.

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