##Colon Usage on Method Calls

Use :: only to reference constants and constructors. Do not use :: for regular method invocation

**Example:**

```
# bad
SomeClass::some_method

# good
SomeClass.some_method
```