
This cop checks for ambiguous block association with method
when param passed without parentheses.

# Examples

```ruby

# bad
some_method a { |val| puts val }
# good
# With parentheses, there's no ambiguity.
some_method(a) { |val| puts val }

# good
# Operator methods require no disambiguation
foo == bar { |b| b.baz }

# good
# Lambda arguments require no disambiguation
foo = ->(bar) { bar.baz }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/AmbiguousBlockAssociation)