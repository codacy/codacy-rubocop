##Nested Method Definitions

Checks for Nested Method Definitions since they actually produce a method in the same scope as the invoker, and everytime you call the outer method you are redifining the function again
If you really need neted functions you should use ```lambda``` instead

**Example:**

```
# bar definition actually produces methods in the same scope as
#the outer foo method. Futhermore, the bar method will be redifined every time the foo is invoked
def foo
  def bar

  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/NestedMethodDefinition)
