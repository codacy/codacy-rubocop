##Infinite Loop

Although infinite loops are a common bad practice if you really intend in using them
you should use ```Kernel#loop``` instead of ```while true```

**Example:**

```
# bad
while true
  work
end

# good
loop do
  work
end
```