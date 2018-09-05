
This cop checks for ambiguous regexp literals in the first argument of
a method invocation without parentheses.

# Examples

```ruby

# bad

# This is interpreted as a method invocation with a regexp literal,
# but it could possibly be `/` method invocations.
# (i.e. `do_something./(pattern)./(i)`)
do_something /pattern/i
# good

# With parentheses, there's no ambiguity.
do_something(/pattern/i)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/AmbiguousRegexpLiteral)