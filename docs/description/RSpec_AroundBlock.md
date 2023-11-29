
Checks that around blocks actually run the test.

# Examples

```ruby
# bad
around do
  some_method
end

around do |test|
  some_method
end

# good
around do |test|
  some_method
  test.call
end

around do |test|
  some_method
  test.run
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/AroundBlock)