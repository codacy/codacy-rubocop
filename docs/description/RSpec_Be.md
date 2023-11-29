
Check for expectations where `be` is used without argument.

The `be` matcher is too generic, as it pass on everything that is not
nil or false. If that is the exact intend, use `be_truthy`. In all other
cases it's better to specify what exactly is the expected value.

# Examples

```ruby
# bad
expect(foo).to be

# good
expect(foo).to be_truthy
expect(foo).to be 1.0
expect(foo).to be(true)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Be)