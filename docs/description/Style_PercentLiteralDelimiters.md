
Enforces the consistent usage of `%`-literal delimiters.
Using consistent delimiters across the codebase reduces
cognitive load when reading `%`-literals.

Specify the 'default' key to set all preferred delimiters at once. You
can continue to specify individual preferred delimiters to override the
default.

# Examples

```ruby
# Style/PercentLiteralDelimiters:
#   PreferredDelimiters:
#     default: '[]'
#     '%i':    '()'

# good
%w[alpha beta] + %i(gamma delta)

# bad
%W(alpha #{beta})

# bad
%I(alpha beta)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/PercentLiteralDelimiters)