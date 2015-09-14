Checks for useless access modifiers without any code since they are redundant

**Example:**

```
class Foo
  private #this is not being used remove it

  def self.some_method
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UselessAccessModifier)