
This cop checks for uses of `and` and `or`, and suggests using `&&` and
`|| instead`. It can be configured to check only in conditions, or in
all contexts.

# Examples

```ruby
# bad
foo.save and return

# bad
if foo and bar
end

# good
foo.save && return

# good
if foo && bar
end# bad
if foo and bar
end

# good
foo.save && return

# good
foo.save and return

# good
if foo && bar
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/AndOr)