
Checks for ambiguous ranges.

Ranges have quite low precedence, which leads to unexpected behavior when
using a range with other operators. This cop avoids that by making ranges
explicit by requiring parenthesis around complex range boundaries (anything
that is not a literal: numerics, strings, symbols, etc.).

This cop can be configured with `RequireParenthesesForMethodChains` in order to
specify whether method chains (including `self.foo`) should be wrapped in parens
by this cop.

NOTE: Regardless of this configuration, if a method receiver is a basic literal
value, it will be wrapped in order to prevent the ambiguity of `1..2.to_a`.

# Examples

```ruby
# bad
x || 1..2
x - 1..2
(x || 1..2)
x || 1..y || 2
1..2.to_a

# good, unambiguous
1..2
'a'..'z'
:bar..:baz
MyClass::MIN..MyClass::MAX
@min..@max
a..b
-a..b

# good, ambiguity removed
x || (1..2)
(x - 1)..2
(x || 1)..2
(x || 1)..(y || 2)
(1..2).to_a# good
a.foo..b.bar
(a.foo)..(b.bar)# bad
a.foo..b.bar

# good
(a.foo)..(b.bar)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/AmbiguousRange)