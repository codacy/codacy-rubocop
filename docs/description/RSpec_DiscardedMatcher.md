
Checks for matchers that are used in void context.

Matcher calls like `change`, `receive`, etc. that appear as
standalone expressions have their result silently discarded.
This usually means a missing `.and` to chain compound matchers.

The list of matcher methods can be configured
with `CustomMatcherMethods`.

# Examples

```ruby
# bad
specify do
  expect { result }
    .to change { obj.foo }.from(1).to(2)
    change { obj.bar }.from(3).to(4)
end

# good
specify do
  expect { result }
    .to change { obj.foo }.from(1).to(2)
    .and change { obj.bar }.from(3).to(4)
end

# good
specify do
  expect { result }.to change { obj.foo }.from(1).to(2)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/DiscardedMatcher)