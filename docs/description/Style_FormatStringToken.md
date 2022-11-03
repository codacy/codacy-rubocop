
Use a consistent style for named format string tokens.

NOTE: `unannotated` style cop only works for strings
which are passed as arguments to those methods:
`printf`, `sprintf`, `format`, `%`.
The reason is that _unannotated_ format is very similar
to encoded URLs or Date/Time formatting strings.

This cop can be customized allowed methods with `AllowedMethods`.
By default, there are no methods to allowed.

It is allowed to contain unannotated token
if the number of them is less than or equals to
`MaxUnannotatedPlaceholdersAllowed`.

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
format('%{greeting}', greeting: 'Hello')

# good
format('%s', 'Hello')
# bad
format('%06d', 10)
format('%s %s.', 'Hello', 'world')

# good
format('%<number>06d', number: 10)
# bad
format('%s %s.', 'Hello', 'world')

# good
format('%06d', 10)
# bad
redirect('foo/%{bar_id}')
# good
redirect('foo/%{bar_id}')
# bad
redirect('foo/%{bar_id}')
# good
redirect('foo/%{bar_id}')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/FormatStringToken)