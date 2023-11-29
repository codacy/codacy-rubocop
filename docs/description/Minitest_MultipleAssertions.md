
Checks if test cases contain too many assertion calls. If conditional code with assertions
is used, the branch with maximum assertions is counted.
The maximum allowed assertion calls is configurable.

# Examples

```ruby
# bad
class FooTest < Minitest::Test
  def test_asserts_twice
    assert_equal(42, do_something)
    assert_empty(array)
  end
end

# good
class FooTest < Minitest::Test
  def test_asserts_once
    assert_equal(42, do_something)
  end

  def test_another_asserts_once
    assert_empty(array)
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/MultipleAssertions)