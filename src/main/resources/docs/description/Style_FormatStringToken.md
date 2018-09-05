
Use a consistent style for named format string tokens.

**Note:**
`unannotated` style cop only works for strings
which are passed as arguments to those methods:
`sprintf`, `format`, `%`.
The reason is that *unannotated* format is very similar
to encoded URLs or Date/Time formatting strings.

# Examples

```ruby

# bad
format('%{greeting}', greeting: 'Hello')
format('%s', 'Hello')

# good
format('%<greeting>s', greeting: 'Hello')
# bad
format('%<greeting>s', greeting: 'Hello')
format('%s', 'Hello')

# good
format('%{greeting}', greeting: 'Hello')
# bad
format('%<greeting>s', greeting: 'Hello')
format('%{greeting}', 'Hello')

# good
format('%s', 'Hello')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/FormatStringToken)