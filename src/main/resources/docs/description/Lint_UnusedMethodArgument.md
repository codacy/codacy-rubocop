Checks for unused method argument in your code since they will not be used (unused arguments prefixed with '_' will be ignored though)

**Example:**

```
#Remove unused argument
def something(used, unused)
  puts used
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UnusedMethodArgument)