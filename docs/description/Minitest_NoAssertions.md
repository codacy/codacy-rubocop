
Checks if test cases contain any assertion calls.

# Examples

```ruby
# bad
class FooTest < Minitest::Test
  def test_the_truth
  end
end

# good
class FooTest < Minitest::Test
  def test_the_truth
    assert true
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/NoAssertions)