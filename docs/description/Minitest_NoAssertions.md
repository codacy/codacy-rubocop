
Checks if test cases contain any assertion calls.

Matchers such as `must_equal` and `wont_match` are also treated as assertion methods.

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

# bad
class FooTest < ActiveSupport::TestCase
  describe 'foo' do
    it 'test equal' do
    end
  end
end

# good
class FooTest < ActiveSupport::TestCase
  describe 'foo' do
    it 'test equal' do
      musts.must_equal expected_musts
    end
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/NoAssertions)