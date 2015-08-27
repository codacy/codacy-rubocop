##Class Methods

Use self instead of defining a method using the class/module name since it provides better readability

**Example:**

```
# bad
class SomeClass
  def SomeClass.some_method

  end
end

# good
class SomeClass
  def self.some_method

  end
end
```