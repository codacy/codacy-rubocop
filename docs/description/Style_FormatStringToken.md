
Use a consistent style for tokens within a format string.

By default, all strings are evaluated. In some cases, this may be undesirable,
as they could be used as arguments to a method that does not consider
them to be tokens, but rather other identifiers or just part of the string.

`AllowedMethods` or `AllowedPatterns` can be configured with in order to mark specific
methods as always allowed, thereby avoiding an offense from the cop. By default, there
are no allowed methods.

Additionally, the cop can be made conservative by configuring it with
`Mode: conservative` (default `aggressive`). In this mode, tokens (regardless
of `EnforcedStyle`) are only considered if used in the format string argument to the
methods `printf`, `sprintf`, `format` and `%`.

NOTE: Tokens in the `unannotated` style (eg. `%s`) are always treated as if
configured with `Conservative: true`. This is done in order to prevent false positives,
because this format is very similar to encoded URLs or Date/Time formatting strings.

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
redirect('foo/%{bar_id}')# In `conservative` mode, offenses are only registered for strings
# given to a known formatting method.

# good
"%{greeting}"
foo("%{greeting}")

# bad
format("%{greeting}", greeting: 'Hello')
printf("%{greeting}", greeting: 'Hello')
sprintf("%{greeting}", greeting: 'Hello')
"%{greeting}" % { greeting: 'Hello' }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/FormatStringToken)