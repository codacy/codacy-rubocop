
This cop check for uses of Object#freeze on immutable objects.

# Examples

```ruby
# bad
CONST = 1.freeze

# good
CONST = 1
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantFreeze)