
This cop check for uses of `Object#freeze` on immutable objects.

NOTE: Regexp and Range literals are frozen objects since Ruby 3.0.

# Examples

```ruby
# bad
CONST = 1.freeze

# good
CONST = 1
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantFreeze)