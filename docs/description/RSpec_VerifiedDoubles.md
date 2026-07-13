
Prefer using verifying doubles over normal doubles.

# Examples

```ruby
# bad
let(:foo) do
  double("ClassName", method_name: 'returned value')
end

# bad
let(:foo) do
  spy("ClassName", method_name: 'returned value')
end

# good
let(:foo) do
  instance_double("ClassName", method_name: 'returned value')
end

# good
let(:foo) do
  class_double("ClassName", method_name: 'returned value')
end

# good
let(:foo) do
  object_double("some object", method_name: 'returned value')
end

# good
let(:foo) do
  double(method_name: 'returned value')
end

# good
let(:foo) do
  double
end

# bad
let(:foo) do
  double(method_name: 'returned value')
end

# bad
let(:foo) do
  double
end

# bad
let(:foo) do
  double(:foo)
end

# good
let(:foo) do
  double(:foo)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/VerifiedDoubles)