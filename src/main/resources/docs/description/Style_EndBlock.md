##END Block usage

You should not use END Block, instead use ```Kernel#at_exit```

**Example:**

```
# bad
END { puts 'Goodbye!' }

# good
at_exit { puts 'Goodbye!' }
```