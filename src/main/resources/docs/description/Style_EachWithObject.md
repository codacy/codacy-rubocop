##Each With Object Usage


Use each_with_object in order to reduce inject calls where the passed in object is returned at the end

**Example:**

```
# bad
[1, 2].inject({}) { |a, e| a[e] = e; a }

# good
[1, 2].each_with_object({}) { |e, a| a[e] = e }
```