
Description should be descriptive.

If example group or example contains only `execute string`, numbers
and regular expressions, the description is not clear.

# Examples

```ruby
# bad
describe `time` do
 # ...
end

# bad
context /when foo/ do
  # ...
end

# bad
it 10000 do
  # ...
end

# good
describe Foo do
  # ...
end

# good
describe '#foo' do
  # ...
end

# good
context "when #{foo} is bar" do
  # ...
end

# good
it 'does something' do
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/UndescriptiveLiteralsDescription)