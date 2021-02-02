
This cop checks for string literal concatenation at
the end of a line.

# Examples

```ruby

# bad
some_str = 'ala' +
           'bala'

some_str = 'ala' <<
           'bala'

# good
some_str = 'ala' \
           'bala'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/LineEndConcatenation)