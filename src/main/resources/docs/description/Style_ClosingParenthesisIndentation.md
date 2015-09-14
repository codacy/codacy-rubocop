**Examples:**

```
# good: when x is on its own line, indent this way
func(
  x,
  y
)

# good: when x follows opening parenthesis, align parentheses
a = b * (x +
         y
        )

# bad
def func(
  x,
  y
  )
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ClosingParenthesisIndentation)