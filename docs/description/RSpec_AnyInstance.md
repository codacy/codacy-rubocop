
Check that instances are not being stubbed globally.

Prefer instance doubles over stubbing any instance of a class

# Examples

```ruby
# bad
describe MyClass do
  before { allow_any_instance_of(MyClass).to receive(:foo) }
end

# good
describe MyClass do
  let(:my_instance) { instance_double(MyClass) }

  before do
    allow(MyClass).to receive(:new).and_return(my_instance)
    allow(my_instance).to receive(:foo)
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/AnyInstance)