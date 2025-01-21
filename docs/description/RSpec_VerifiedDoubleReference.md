
Checks for consistent verified double reference style.

# Examples

```ruby
# bad
let(:foo) do
  instance_double('ClassName', method_name: 'returned_value')
end

# good
let(:foo) do
  instance_double(ClassName, method_name: 'returned_value')
end
# good
let(:foo) do
  instance_double(@klass, method_name: 'returned_value')
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/VerifiedDoubleReference)