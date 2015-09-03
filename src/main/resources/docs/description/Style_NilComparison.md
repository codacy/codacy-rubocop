##Nil comparison

Favor the use of the predicate method nil? instead ==

**Example:**

```
# bad
if x == nil
end

# good
if x.nil?
end
```