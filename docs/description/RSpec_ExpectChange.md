
Checks for consistent style of change matcher.

Enforces either passing a receiver and message as method arguments,
or a block.

This cop can be configured using the `EnforcedStyle` option.

When using compound expectations with `change` and a negated matcher
(e.g., `not_change`), you can configure the `NegatedMatcher` option
to ensure consistent style enforcement across both matchers.

# Examples

```ruby
# bad
expect { run }.to change { Foo.bar }
expect { run }.to change { foo.baz }

# good
expect { run }.to change(Foo, :bar)
expect { run }.to change(foo, :baz)
# also good when there are arguments or chained method calls
expect { run }.to change { Foo.bar(:count) }
expect { run }.to change { user.reload.name }

# bad
expect { run }.to change(Foo, :bar)

# good
expect { run }.to change { Foo.bar }

# bad
expect { run }.to change(Foo, :bar).and not_change { Foo.baz }

# good
expect { run }.to change(Foo, :bar).and not_change(Foo, :baz)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ExpectChange)