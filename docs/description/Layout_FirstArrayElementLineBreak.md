
Checks for a line break before the first element in a
multi-line array.

NOTE: An array whose first element is an array literal is not checked when
`Layout/SpaceInsideArrayLiteralBrackets` is enabled with `EnforcedStyle: compact`,
since that style joins the two opening brackets.

# Examples

```ruby

# bad
[ :a,
  :b]

# good
[
  :a,
  :b]

# good
[:a, :b]


# bad
a = b,
    c

# good
a =
  b,
  c


# good
a = b,
    c

a =
  b,
  c


# bad
[ :a, {
  :b => :c
}]

# good
[
  :a, {
  :b => :c
}]


# good
[:a, {
  :b => :c
}]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/FirstArrayElementLineBreak)