
Prefer using predicate matcher over using predicate method directly.

RSpec defines magic matchers for predicate methods.
This cop recommends to use the predicate matcher instead of using
predicate method directly.

# Examples

```ruby
# bad
expect(foo.something?).to be_truthy

# good
expect(foo).to be_something

# also good - It checks "true" strictly.
expect(foo.something?).to be(true)# bad
expect(foo.something?).to be_truthy
expect(foo.something?).to be(true)

# good
expect(foo).to be_something# bad
expect(foo).to be_something

# good - the above code is rewritten to it by this cop
expect(foo.something?).to be(true)

# bad - no autocorrect
expect(foo)
  .to be_something(<<~TEXT)
    bar
  TEXT

# good
expect(foo.something?(<<~TEXT)).to be(true)
  bar
TEXT# bad
expect(foo).to be_something

# good - the above code is rewritten to it by this cop
expect(foo.something?).to be_truthy
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/PredicateMatcher)