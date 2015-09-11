##Line End Concatenation

You should use \ instead of + and << since it is the standart for the ruby language

**Example:**

```

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
