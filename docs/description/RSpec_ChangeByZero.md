
Prefer negated matchers over `to change.by(0)`.

In the case of composite expectations, cop suggest using the
negation matchers of `RSpec::Matchers#change`.

By default the cop does not support autocorrect of
compound expectations, but if you set the
negated matcher for `change`, e.g. `not_change` with
the `NegatedMatcher` option, the cop will perform the autocorrection.

# Examples

```ruby
# bad
expect { run }.to change(Foo, :bar).by(0)
expect { run }.to change { Foo.bar }.by(0)

# bad - compound expectations (does not support autocorrection)
expect { run }
  .to change(Foo, :bar).by(0)
  .and change(Foo, :baz).by(0)
expect { run }
  .to change { Foo.bar }.by(0)
  .and change { Foo.baz }.by(0)

# good
expect { run }.not_to change(Foo, :bar)
expect { run }.not_to change { Foo.bar }

# good - compound expectations
define_negated_matcher :not_change, :change
expect { run }
  .to not_change(Foo, :bar)
  .and not_change(Foo, :baz)
expect { run }
  .to not_change { Foo.bar }
  .and not_change { Foo.baz }# bad (support autocorrection to good case)
expect { run }
  .to change(Foo, :bar).by(0)
  .and change(Foo, :baz).by(0)
expect { run }
  .to change { Foo.bar }.by(0)
  .and change { Foo.baz }.by(0)

# good
define_negated_matcher :not_change, :change
expect { run }
  .to not_change(Foo, :bar)
  .and not_change(Foo, :baz)
expect { run }
  .to not_change { Foo.bar }
  .and not_change { Foo.baz }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ChangeByZero)