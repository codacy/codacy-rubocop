##Case Equality

Avoid explicit use of the case equality operator ===. As its name implies it is meant to be
used by case expressions and outside of them it yields some pretty confusing code


**Example:**

```
# bad
Array === something

# good
something.is_a?(Array)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CaseEquality)
