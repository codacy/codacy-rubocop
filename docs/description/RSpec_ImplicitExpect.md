
Check that a consistent implicit expectation style is used.

This cop can be configured using the `EnforcedStyle` option
and supports the `--auto-gen-config` flag.

# Examples

```ruby
# bad
it { should be_truthy }

# good
it { is_expected.to be_truthy }# bad
it { is_expected.to be_truthy }

# good
it { should be_truthy }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ImplicitExpect)