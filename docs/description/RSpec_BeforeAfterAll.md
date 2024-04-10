
Check that before/after(:all) isn't being used.

# Examples

```ruby
# bad
#
# Faster but risk of state leaking between examples
#
describe MyClass do
  before(:all) { Widget.create }
  after(:all) { Widget.delete_all }
end

# good
#
# Slower but examples are properly isolated
#
describe MyClass do
  before(:each) { Widget.create }
  after(:each) { Widget.delete_all }
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/BeforeAfterAll)