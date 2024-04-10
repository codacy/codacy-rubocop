
Checks for places where binary operator has identical operands.

It covers arithmetic operators: `-`, `/`, `%`;
comparison operators: `==`, `===`, `=~`, `>`, `>=`, `<`, `<=`;
bitwise operators: `|`, `^`, `&`;
boolean operators: `&&`, `||`
and "spaceship" operator - `<=>`.

Simple arithmetic operations are allowed by this cop: `+`, `*`, `**`, `<<` and `>>`.
Although these can be rewritten in a different way, it should not be necessary to
do so. This does not include operations such as `-` or `/` where the result will
always be the same (`x - x` will always be 0; `x / x` will always be 1), and
thus are legitimate offenses.

# Examples

```ruby
# bad
x / x
x.top >= x.top

if a.x != 0 && a.x != 0
  do_something
end

def child?
  left_child || left_child
end

# good
x + x
1 << 1
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/BinaryOperatorWithIdenticalOperands)