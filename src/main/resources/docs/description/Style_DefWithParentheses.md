##Def With Parentheses

Use def with parenthesis when there are parameters. Omit the parentheses when the method does not accept any parameters

**Example:**

```
# bad
def some_method hello, world
  ...
end

# good
def some_method(hello, world)
  ...
end
```