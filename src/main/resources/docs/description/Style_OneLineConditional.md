##One Line Conditional

Favor the ternary operator(?:) over if/then/else/end constructs. It's more common and obviously more concise.

**Example:**

```
# bad
result = if some_condition then something else something_else end

# good
result = some_condition ? something : something_else
```