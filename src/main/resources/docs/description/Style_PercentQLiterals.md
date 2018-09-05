
This cop checks for usage of the %Q() syntax when %q() would do.

# Examples

```ruby
# The `lower_case_q` style prefers `%q` unless
# interpolation is needed.
# bad
%Q[Mix the foo into the baz.]
%Q(They all said: 'Hooray!')

# good
%q[Mix the foo into the baz]
%q(They all said: 'Hooray!')# The `upper_case_q` style requires the sole use of `%Q`.
# bad
%q/Mix the foo into the baz./
%q{They all said: 'Hooray!'}

# good
%Q/Mix the foo into the baz./
%Q{They all said: 'Hooray!'}
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/PercentQLiterals)