
Checks the spacing inside and after block parameters pipes. Line breaks
inside parameter pipes are checked by `Layout/MultilineBlockLayout` and
not by this cop. Spaces inside a lambda's parameter parentheses are left
to `Layout/SpaceInsideParens` when that cop is enabled, so the examples
below apply to a lambda only when it is not.

# Examples

```ruby
# bad
{}.each { | x,  y |puts x }
->( x,  y ) { puts x }

# good
{}.each { |x, y| puts x }
->(x, y) { puts x }

# bad
{}.each { |x,  y| puts x }
->(x,  y) { puts x }

# good
{}.each { | x, y | puts x }
->( x, y ) { puts x }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceAroundBlockParameters)