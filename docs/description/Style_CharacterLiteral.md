
Checks for uses of the character literal ?x.
Starting with Ruby 1.9 character literals are
essentially one-character strings, so this syntax
is mostly redundant at this point.

? character literal can be used to express meta and control character.
That's a good use case of ? literal so it doesn't count it as an offense.

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