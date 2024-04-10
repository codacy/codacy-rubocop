
Checks for redundant predicate matcher.

# Examples

```ruby
# bad
expect(foo).to be_exist(bar)
expect(foo).not_to be_include(bar)
expect(foo).to be_all(bar)

# good
expect(foo).to exist(bar)
expect(foo).not_to include(bar)
expect(foo).to all be(bar)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/RedundantPredicateMatcher)