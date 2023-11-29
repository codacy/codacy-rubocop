
Checks for `instance_double` used with `have_received`.

# Examples

```ruby
# bad
it do
  foo = instance_double(Foo).as_null_object
  expect(foo).to have_received(:bar)
end

# good
it do
  foo = instance_spy(Foo)
  expect(foo).to have_received(:bar)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/InstanceSpy)