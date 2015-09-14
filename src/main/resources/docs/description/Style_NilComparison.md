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

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NilComparison)