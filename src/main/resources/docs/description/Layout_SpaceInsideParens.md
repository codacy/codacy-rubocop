
Checks for spaces inside ordinary round parentheses.

# Examples

```ruby
# The `no_space` style enforces that parentheses do not have spaces.

# bad
f( 3)
g = (a + 3 )

# good
f(3)
g = (a + 3)# The `space` style enforces that parentheses have a space at the
# beginning and end.
# Note: Empty parentheses should not have spaces.

# bad
f(3)
g = (a + 3)
y( )

# good
f( 3 )
g = ( a + 3 )
y()
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceInsideParens)