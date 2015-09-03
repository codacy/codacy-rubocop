##Method Def Parentheses

Although ruby supports parameters in a method declaration without them being wrapped inside parentheses
you should always do it, since it provides more readability to your code

**Example:**

```
# bad
def something hello, world

end

# good
def something(hello, world)

end
```