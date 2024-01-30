
Checks for the use of test methods outside of a test class.

Test methods should be defined within a test class to ensure their execution.

NOTE: This cop assumes that classes whose superclass name includes the word
"`Test`" are test classes, in order to prevent false positives.

# Examples

```ruby

# bad
class FooTest < Minitest::Test
end
def test_method_should_be_inside_test_class
end

# good
class FooTest < Minitest::Test
  def test_method_should_be_inside_test_class
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/NonExecutableTestMethod)