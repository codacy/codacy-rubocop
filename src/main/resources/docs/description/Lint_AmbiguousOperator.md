
This cop checks for ambiguous operators in the first argument of a
method invocation without parentheses.

# Examples

```ruby

# bad

# The `*` is interpreted as a splat operator but it could possibly be
# a `*` method invocation (i.e. `do_something.*(some_array)`).
do_something *some_array
# good

# With parentheses, there's no ambiguity.
do_something(*some_array)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/AmbiguousOperator)