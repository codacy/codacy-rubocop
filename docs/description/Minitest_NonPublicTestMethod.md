
Detects non `public` (marked as `private` or `protected`) test methods.
Minitest runs only test methods which are `public`.

# Examples

```ruby
# bad
class FooTest
  private # or protected
  def test_does_something
    assert_equal 42, do_something
  end
end

# good
class FooTest
  def test_does_something
    assert_equal 42, do_something
  end
end

# good (not a test case name)
class FooTest
  private # or protected
  def does_something
    assert_equal 42, do_something
  end
end

# good (no assertions)
class FooTest
  private # or protected
  def test_does_something
    do_something
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/NonPublicTestMethod)