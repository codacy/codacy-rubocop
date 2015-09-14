You should omit parentheses for method calls with no arguments.

**Example:**

```
# bad
Kernel.exit!()
2.even?()
fork()
'test'.upcase()

# good
Kernel.exit!
2.even?
fork
'test'.upcase
```


[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MethodCallParentheses)