
Enforces use of `be_invalid` or `not_to` for negated be_valid.

# Examples

```ruby
# bad
expect(foo).to be_invalid

# good
expect(foo).not_to be_valid

# good (with method chain)
expect(foo).to be_invalid.and be_odd# bad
expect(foo).not_to be_valid

# good
expect(foo).to be_invalid

# good (with method chain)
expect(foo).to be_invalid.or be_even
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Rails/NegationBeValid)