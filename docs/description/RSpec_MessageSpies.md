
Checks that message expectations are set using spies.

This cop can be configured in your configuration using the
`EnforcedStyle` option and supports `--auto-gen-config`.

# Examples

```ruby

# bad
expect(foo).to receive(:bar)
do_something

# good
allow(foo).to receive(:bar) # or use instance_spy
do_something
expect(foo).to have_received(:bar)
# bad
allow(foo).to receive(:bar)
do_something
expect(foo).to have_received(:bar)

# good
expect(foo).to receive(:bar)
do_something
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/MessageSpies)