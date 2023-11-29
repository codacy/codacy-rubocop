
Checks that the second argument to `describe` specifies a method.

# Examples

```ruby
# bad
describe MyClass, 'do something' do
end

# good
describe MyClass, '#my_instance_method' do
end

describe MyClass, '.my_class_method' do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/DescribeMethod)