
Checks for ambiguous block association with method
when param passed without parentheses.

This cop can customize allowed methods with `AllowedMethods`.
By default, there are no methods to allowed.

# Examples

```ruby

# bad
some_method a { |val| puts val }

# good
# With parentheses, there's no ambiguity.
some_method(a { |val| puts val })
# or (different meaning)
some_method(a) { |val| puts val }

# good
# Operator methods require no disambiguation
foo == bar { |b| b.baz }

# good
# Lambda arguments require no disambiguation
foo = ->(bar) { bar.baz }
# bad
expect { do_something }.to change { object.attribute }
# good
expect { do_something }.to change { object.attribute }
# bad
expect { do_something }.to change { object.attribute }
# good
expect { do_something }.to change { object.attribute }
expect { do_something }.to not_change { object.attribute }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/AmbiguousBlockAssociation)