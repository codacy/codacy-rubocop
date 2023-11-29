
Checks if there is an empty line after hook blocks.

`AllowConsecutiveOneLiners` configures whether adjacent
one-line definitions are considered an offense.

# Examples

```ruby
# bad
before { do_something }
it { does_something }

# bad
after { do_something }
it { does_something }

# bad
around { |test| test.run }
it { does_something }

# good
after { do_something }

it { does_something }

# fair - it's ok to have non-separated one-liners hooks
around { |test| test.run }
after { do_something }

it { does_something }# rubocop.yml
# RSpec/EmptyLineAfterHook:
#   AllowConsecutiveOneLiners: false

# bad
around { |test| test.run }
after { do_something }

it { does_something }

# good
around { |test| test.run }

after { do_something }

it { does_something }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/EmptyLineAfterHook)