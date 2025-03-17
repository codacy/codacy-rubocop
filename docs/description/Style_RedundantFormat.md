
Checks for calls to `Kernel#format` or `Kernel#sprintf` that are redundant.

Calling `format` with only a single string argument is redundant, as it can be
replaced by the string itself.

Also looks for `format` calls where the arguments are literals that can be
inlined into a string easily. This applies to the `%s`, `%d`, `%i`, `%u`, and
`%f` format specifiers.

# Examples

```ruby

# bad
format('the quick brown fox jumps over the lazy dog.')
sprintf('the quick brown fox jumps over the lazy dog.')

# good
'the quick brown fox jumps over the lazy dog.'

# bad
format('%s %s', 'foo', 'bar')
sprintf('%s %s', 'foo', 'bar')

# good
'foo bar'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantFormat)