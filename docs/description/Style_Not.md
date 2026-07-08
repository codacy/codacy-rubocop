
Checks for uses of the keyword `not` instead of `!`.
The `not` keyword has lower precedence than `!`, which can
lead to surprising behavior and often requires parentheses.

# Examples

```ruby

# bad - parentheses are required because of op precedence
x = (not something)

# good
x = !something
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Not)