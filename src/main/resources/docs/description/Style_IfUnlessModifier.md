##If/Unless Modifier

You should favor modifier if/unless usage when you have a single-line body. Another good alternative is the usage of control flow &&/||

**Example:**

```
# bad
if some_condition
  do_something
end

# good
do_something if some_condition

# another good option
some_condition && do_something
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/IfUnlessModifier)
