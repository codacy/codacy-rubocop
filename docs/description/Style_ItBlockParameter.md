
Checks for blocks with one argument where `it` block parameter can be used.

It provides three `EnforcedStyle` options:

1. `only_numbered_parameters` (default) ... Detects only numbered block parameters.
2. `always` ... Always uses the `it` block parameter.
3. `disallow` ... Disallows the `it` block parameter.

A single numbered parameter is detected when `only_numbered_parameters` or `always`.

# Examples

```ruby
# bad
block { do_something(_1) }

# good
block { do_something(it) }
block { |named_param| do_something(named_param) }# bad
block { do_something(_1) }
block { |named_param| do_something(named_param) }

# good
block { do_something(it) }# bad
block { do_something(it) }

# good
block { do_something(_1) }
block { |named_param| do_something(named_param) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ItBlockParameter)