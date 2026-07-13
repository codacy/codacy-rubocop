
Checks for method calls with at least one argument where no parentheses
are used around the parameter list, and the call could be misread as an
operand of a boolean operator (`&&` or `||`). Two forms are flagged:

* a predicate method whose last argument is a `&&`/`||` expression, and
* any method whose first argument is a ternary expression with a
  `&&`/`||` condition.

The idea behind warning for these constructs is that the user might
be under the impression that the return value from the method call is
an operand of &&/||.

# Examples

```ruby

# bad
if day.is? :tuesday && month == :jan
  # ...
end

# good
if day.is?(:tuesday) && month == :jan
  # ...
end

# bad
foo a && b ? c : d

# good
foo(a && b ? c : d)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/RequireParentheses)