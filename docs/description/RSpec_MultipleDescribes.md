
Checks for multiple top-level example groups.

Multiple descriptions for the same class or module should either
be nested or separated into different test files.

# Examples

```ruby
# bad
describe MyClass, '.do_something' do
end
describe MyClass, '.do_something_else' do
end

# good
describe MyClass do
  describe '.do_something' do
  end
  describe '.do_something_else' do
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/MultipleDescribes)