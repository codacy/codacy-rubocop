
This cop detects instances of rubocop:enable comments that can be
removed.

When comment enables all cops at once `rubocop:enable all`
that cop checks whether any cop was actually enabled.

# Examples

```ruby
# bad
foo = 1
# rubocop:enable Metrics/LineLength

# good
foo = 1# bad
# rubocop:disable Metrics/LineLength
baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaarrrrrrrrrrrrr
# rubocop:enable Metrics/LineLength
baz
# rubocop:enable all

# good
# rubocop:disable Metrics/LineLength
baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaarrrrrrrrrrrrr
# rubocop:enable all
baz
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UnneededCopEnableDirective)