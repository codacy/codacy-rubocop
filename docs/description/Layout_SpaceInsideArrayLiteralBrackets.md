
Checks that brackets used for array literals have or don't have
surrounding space depending on configuration.

Array pattern matching is handled in the same way.

# Examples

```ruby
# The `no_space` style enforces that array literals have
# no surrounding space.

# bad
array = [ a, b, c, d ]
array = [ a, [ b, c ]]

# good
array = [a, b, c, d]
array = [a, [b, c]]# The `space` style enforces that array literals have
# surrounding space.

# bad
array = [a, b, c, d]
array = [ a, [ b, c ]]

# good
array = [ a, b, c, d ]
array = [ a, [ b, c ] ]# The `compact` style normally requires a space inside
# array brackets, with the exception that successive left
# or right brackets are collapsed together in nested arrays.

# bad
array = [a, b, c, d]
array = [ a, [ b, c ] ]
array = [
  [ a ],
  [ b, c ]
]

# good
array = [ a, b, c, d ]
array = [ a, [ b, c ]]
array = [[ a ],
  [ b, c ]]# The `no_space` EnforcedStyleForEmptyBrackets style enforces that
# empty array brackets do not contain spaces.

# bad
foo = [ ]
bar = [     ]

# good
foo = []
bar = []# The `space` EnforcedStyleForEmptyBrackets style enforces that
# empty array brackets contain exactly one space.

# bad
foo = []
bar = [    ]

# good
foo = [ ]
bar = [ ]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceInsideArrayLiteralBrackets)