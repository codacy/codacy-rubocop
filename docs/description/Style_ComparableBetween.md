
Checks for logical comparison which can be replaced with `Comparable#between?`.

NOTE: `Comparable#between?` is on average slightly slower than logical comparison,
although the difference generally isn't observable. If you require maximum
performance, consider using logical comparison.

# Examples

```ruby

# bad
x >= min && x <= max

# bad
x <= max && x >= min

# good
x.between?(min, max)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ComparableBetween)