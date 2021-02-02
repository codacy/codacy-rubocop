
This cop checks for uses of the keyword `not` instead of `!`.

# Examples

```ruby

# bad - parentheses are required because of op precedence
x = (not something)

# good
x = !something
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Not)