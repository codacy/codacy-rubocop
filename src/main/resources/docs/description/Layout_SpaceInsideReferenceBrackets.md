
Checks that reference brackets have or don't have
surrounding space depending on configuration.

# Examples

```ruby
# The `no_space` style enforces that reference brackets have
# no surrounding space.

# bad
hash[ :key ]
array[ index ]

# good
hash[:key]
array[index]# The `space` style enforces that reference brackets have
# surrounding space.

# bad
hash[:key]
array[index]

# good
hash[ :key ]
array[ index ]# The `no_space` EnforcedStyleForEmptyBrackets style enforces that
# empty reference brackets do not contain spaces.

# bad
foo[ ]
foo[     ]

# good
foo[]# The `space` EnforcedStyleForEmptyBrackets style enforces that
# empty reference brackets contain exactly one space.

# bad
foo[]
foo[    ]

# good
foo[ ]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceInsideReferenceBrackets)