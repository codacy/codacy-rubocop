
Forbids Yoda expressions, i.e. binary operations (using `*`, `+`, `&`, `|`,
and `^` operators) where the order of expression is reversed, eg. `1 + x`.
This cop complements `Style/YodaCondition` cop, which has a similar purpose.

This cop is disabled by default to respect user intentions such as:

[source,ruby]
----
config.server_port = 9000 + ENV["TEST_ENV_NUMBER"].to_i
----

# Examples

```ruby
# bad
1 + x
10 * y
1 & z
1 + CONST

# good
60 * 24
x + 1
y * 10
z & 1
CONST + 1

# good
1 | x
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/YodaExpression)