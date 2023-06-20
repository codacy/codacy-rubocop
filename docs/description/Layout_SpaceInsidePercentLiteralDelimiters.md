
Checks for unnecessary additional spaces inside the delimiters of
%i/%w/%x literals.

# Examples

```ruby

# bad
%i( foo bar baz )

# good
%i(foo bar baz)

# bad
%w( foo bar baz )

# good
%w(foo bar baz)

# bad
%x(  ls -l )

# good
%x(ls -l)

# bad
%w( )
%w(
)

# good
%w()
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceInsidePercentLiteralDelimiters)