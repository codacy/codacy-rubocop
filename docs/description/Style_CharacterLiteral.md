
Checks for uses of the character literal ?x.
Starting with Ruby 1.9 character literals are
essentially one-character strings, so this syntax
is mostly redundant at this point.

A `?` character literal can be used to express meta and control characters.
That's a good use case of a `?` literal so it doesn't count as an offense.

# Examples

```ruby
# bad
?x

# good
'x'

# good - control & meta escapes
?\C-\M-d
"\C-\M-d" # same as above
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CharacterLiteral)