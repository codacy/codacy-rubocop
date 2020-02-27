
Checks that operators have space around them, except for ** which
should or shouldn't have surrounding space depending on configuration.

This cop has `AllowForAlignment` option. When `true`, allows most
uses of extra spacing if the intent is to align with an operator on
the previous or next line, not counting empty lines or comment lines.

# Examples

```ruby
# bad
total = 3*4
"apple"+"juice"
my_number = 38/4

# good
total = 3 * 4
"apple" + "juice"
my_number = 38 / 4# good
{
  1 =>  2,
  11 => 3
}# bad
{
  1 =>  2,
  11 => 3
}# bad
a ** b

# good
a**b# bad
a**b

# good
a ** b
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceAroundOperators)