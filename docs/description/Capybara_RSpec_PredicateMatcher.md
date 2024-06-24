
Prefer using predicate matcher over using predicate method directly.

Capybara defines magic matchers for predicate methods.
This cop recommends to use the predicate matcher instead of using
predicate method directly.

# Examples

```ruby
# bad
expect(foo.matches_css?(bar: 'baz')).to be_truthy
expect(foo.matches_selector?(bar: 'baz')).to be_truthy
expect(foo.matches_style?(bar: 'baz')).to be_truthy
expect(foo.matches_xpath?(bar: 'baz')).to be_truthy

# good
expect(foo).to match_css(bar: 'baz')
expect(foo).to match_selector(bar: 'baz')
expect(foo).to match_style(bar: 'baz')
expect(foo).to match_xpath(bar: 'baz')

# also good - It checks "true" strictly.
expect(foo.matches_style?(bar: 'baz')).to be(true)# bad
expect(foo.matches_style?(bar: 'baz')).to be_truthy
expect(foo.matches_style?(bar: 'baz')).to be(true)

# good
expect(foo).to match_style(bar: 'baz')# bad
expect(foo).to match_style(bar: 'baz')

# good - the above code is rewritten to it by this cop
expect(foo.matches_style?(bar: 'baz')).to be(true)# bad
expect(foo).to match_style(bar: 'baz')

# good - the above code is rewritten to it by this cop
expect(foo.matches_style?(bar: 'baz')).to be_truthy
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/RSpec/PredicateMatcher)