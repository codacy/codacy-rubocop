
Checks that braces used for hash literals have or don't have
surrounding space depending on configuration.

# Examples

```ruby
# The `space` style enforces that hash literals have
# surrounding space.

# bad
h = {a: 1, b: 2}

# good
h = { a: 1, b: 2 }# The `no_space` style enforces that hash literals have
# no surrounding space.

# bad
h = { a: 1, b: 2 }

# good
h = {a: 1, b: 2}# The `compact` style normally requires a space inside
# hash braces, with the exception that successive left
# braces or right braces are collapsed together in nested hashes.

# bad
h = { a: { b: 2 } }

# good
h = { a: { b: 2 }}# The `no_space` EnforcedStyleForEmptyBraces style enforces that
# empty hash braces do not contain spaces.

# bad
foo = { }
bar = {    }

# good
foo = {}
bar = {}# The `space` EnforcedStyleForEmptyBraces style enforces that
# empty hash braces contain space.

# bad
foo = {}

# good
foo = { }
foo = {  }
foo = {     }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceInsideHashLiteralBraces)