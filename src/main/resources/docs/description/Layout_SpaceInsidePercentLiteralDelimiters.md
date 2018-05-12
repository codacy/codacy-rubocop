
Checks for unnecessary additional spaces inside the delimiters of
%i/%w/%x literals.

# Examples

```ruby

# good
%i(foo bar baz)

# bad
%w( foo bar baz )

# bad
%x(  ls -l )
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceInsidePercentLiteralDelimiters)