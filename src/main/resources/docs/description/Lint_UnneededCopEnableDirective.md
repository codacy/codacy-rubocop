
This cop detects instances of rubocop:enable comments that can be
removed.

# Examples

```ruby
# bad
foo = 1
# rubocop:enable Metrics/LineLength

# good
foo = 1
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UnneededCopEnableDirective)