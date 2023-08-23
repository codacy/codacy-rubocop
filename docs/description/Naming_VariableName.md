
Makes sure that all variables use the configured style,
snake_case or camelCase, for their names.

# Examples

```ruby
# bad
fooBar = 1

# good
foo_bar = 1# bad
foo_bar = 1

# good
fooBar = 1# good (with EnforcedStyle: snake_case)
fooBar = 1# good (with EnforcedStyle: camelCase)
:release_v1
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/VariableName)