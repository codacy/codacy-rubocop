
Checks if there is an empty line after example group blocks.

# Examples

```ruby
# bad
RSpec.describe Foo do
  describe '#bar' do
  end
  describe '#baz' do
  end
end

# good
RSpec.describe Foo do
  describe '#bar' do
  end

  describe '#baz' do
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/EmptyLineAfterExampleGroup)