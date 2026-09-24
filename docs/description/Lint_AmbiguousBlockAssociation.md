
Checks for ambiguous block association with method
when param passed without parentheses.

This cop also detects `do...end` blocks that are likely intended for
an enumerable method in the arguments but actually bind to the outer
method call. For example, in `render json: data.map do |x| x end`,
Ruby parses the `do...end` block as belonging to `render`, not `map`.

This cop can customize allowed methods with `AllowedMethods`.
By default, there are no allowed methods.

# Examples

```ruby

# bad
some_method a { |val| puts val }

# good
# With parentheses, there's no ambiguity.
some_method(a { |val| puts val })
# or (different meaning)
some_method(a) { |val| puts val }

# bad
render json: data.map do |item|
  item.to_h
end

# good
render json: data.map { |item| item.to_h }

# good
mapped = data.map { |item| item.to_h }
render json: mapped

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