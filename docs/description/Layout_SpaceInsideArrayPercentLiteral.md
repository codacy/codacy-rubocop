
Checks for unnecessary additional spaces inside array percent literals
(i.e. %i/%w).

Note that blank percent literals (e.g. `%i( )`) are checked by
`Layout/SpaceInsidePercentLiteralDelimiters`.

# Examples

```ruby

# bad
%w(foo  bar  baz)
# good
%i(foo bar baz)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceInsideArrayPercentLiteral)