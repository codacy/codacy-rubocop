##Empty Literals

Don't use Array.new or Hash.new use literals for them instead since they provide cleaner and more readable code

**Example:**

```
# bad
arr = Array.new

# good
arr = []
```