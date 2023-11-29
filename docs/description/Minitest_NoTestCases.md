
Checks if test class contains any test cases.

# Examples

```ruby
# bad
class FooTest < Minitest::Test
  def do_something
  end
end

# good
class FooTest < Minitest::Test
  def test_something
    assert true
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/NoTestCases)