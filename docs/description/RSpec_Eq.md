
Use `eq` instead of `be ==` to compare objects.

# Examples

```ruby
# bad
expect(foo).to be == 42

# good
expect(foo).to eq 42
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Eq)