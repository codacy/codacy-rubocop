
Checks that `remove_const` is not used in specs.

# Examples

```ruby
# bad
it 'does something' do
  Object.send(:remove_const, :SomeConstant)
end

before do
  SomeClass.send(:remove_const, :SomeConstant)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/RemoveConst)