
Checks for usage of assertions in lifecycle hooks.

# Examples

```ruby
# bad
class FooTest < Minitest::Test
  def setup
    assert_equal(foo, bar)
  end
end

# good
class FooTest < Minitest::Test
  def test_something
    assert_equal(foo, bar)
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertionInLifecycleHook)