
Checks for empty strings being assigned inside string interpolation.

Empty strings are a meaningless outcome inside of string interpolation, so we remove them.
Alternatively, when configured to do so, we prioritise using empty strings.

While this cop would also apply to variables that are only going to be used as strings,
RuboCop can't detect that, so we only check inside of string interpolation.

# Examples

```ruby
# bad
"#{condition ? 'foo' : ''}"

# good
"#{'foo' if condition}"

# bad
"#{condition ? '' : 'foo'}"

# good
"#{'foo' unless condition}"# bad
"#{'foo' if condition}"

# good
"#{condition ? 'foo' : ''}"

# bad
"#{'foo' unless condition}"

# good
"#{condition ? '' : 'foo'}"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EmptyStringInsideInterpolation)