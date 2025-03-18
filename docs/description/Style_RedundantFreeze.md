
Check for uses of `Object#freeze` on immutable objects.

NOTE: `Regexp` and `Range` literals are frozen objects since Ruby 3.0.

NOTE: From Ruby 3.0, this cop allows explicit freezing of interpolated
string literals when `# frozen-string-literal: true` is used.

# Examples

```ruby
# bad
CONST = 1.freeze

# good
CONST = 1
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantFreeze)