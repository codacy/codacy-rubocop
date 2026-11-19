
Checks that tests use RSpec `before` instead of Rails `setup`.

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

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpecRails/AvoidSetupHook)