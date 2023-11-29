
If a Minitest class inherits from another class,
it will also inherit its methods causing Minitest to run the parent's tests methods twice.

This cop detects when there are two tests classes, one inherits from the other, and both have tests methods.
This cop will add an offense to the Child class in such a case.

# Examples

```ruby
# bad
class ParentTest < Minitest::Test
  def test_parent # it will run this test twice.
  end
end

class ChildTest < ParentTest
  def test_child
  end
end

# good
class ParentTest < Minitest::Test
  def test_parent
  end
end

class ChildTest < Minitest::Test
  def test_child
  end
end

# good
class ParentTest < Minitest::Test
end

class ChildTest
  def test_child
  end

  def test_parent
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/DuplicateTestRun)