
Checks that tests use RSpec `before` hook over Rails `setup` method.

# Examples

```ruby
# bad
setup do
  allow(foo).to receive(:bar)
end

# good
before do
  allow(foo).to receive(:bar)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Rails/AvoidSetupHook)