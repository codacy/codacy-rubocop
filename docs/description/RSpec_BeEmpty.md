
Prefer using `be_empty` when checking for an empty array.

# Examples

```ruby
# bad
expect(array).to contain_exactly
expect(array).to match_array([])

# good
expect(array).to be_empty
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/BeEmpty)