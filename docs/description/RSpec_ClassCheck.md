
Enforces consistent use of `be_a` or `be_kind_of`.

# Examples

```ruby
# bad
expect(object).to be_kind_of(String)
expect(object).to be_a_kind_of(String)

# good
expect(object).to be_a(String)
expect(object).to be_an(String)# bad
expect(object).to be_a(String)
expect(object).to be_an(String)

# good
expect(object).to be_kind_of(String)
expect(object).to be_a_kind_of(String)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ClassCheck)