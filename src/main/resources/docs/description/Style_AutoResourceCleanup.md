##Auto Resource Cleanup

Check for cases when you could use a block accepting of a method that does automatic resource cleanup

**Example:**

```
#bad
file = File.open('file')

#good
file = File.open('file') do
  ...
end
```