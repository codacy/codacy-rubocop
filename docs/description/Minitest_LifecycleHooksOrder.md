
Checks that lifecycle hooks are declared in the order in which they will be executed.

# Examples

```ruby
# bad
class FooTest < Minitest::Test
  def teardown; end
  def setup; end
end

# good
class FooTest < Minitest::Test
  def setup; end
  def teardown; end
end

# bad (after test cases)
class FooTest < Minitest::Test
  def test_something
    assert foo
  end
  def setup; end
  def teardown; end
end

# good
class FooTest < Minitest::Test
  def setup; end
  def teardown; end
  def test_something
    assert foo
  end
end

# good (after non test case methods)
class FooTest < Minitest::Test
  def do_something; end
  def setup; end
  def teardown; end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/LifecycleHooksOrder)