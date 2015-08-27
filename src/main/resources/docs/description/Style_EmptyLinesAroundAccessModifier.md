##Empty Lines Around Access Modifier

You should put empty lines around an access modifier since that is the convention established for ruby

**Example**

```
# bad

class SomeClass

  def some_method
  end
  private
  def some_other_method
  end
end

# good

class AnotherClass

  def another_method
  end

  private

  def another_other_method
  end

end
```