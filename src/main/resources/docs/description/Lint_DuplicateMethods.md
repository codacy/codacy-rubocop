Checks for duplicate methods in classes and modules, This should be changed since it can give some serious issues in the long run

**Examples**

```
#This is really bad

class SomeClass
  def some_method
  end

  def some_method
  end
end

#You should change them to other names

class SomeClass
  def some
  end

  def method
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DuplicateMethods)