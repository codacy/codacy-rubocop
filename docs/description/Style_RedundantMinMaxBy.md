
Identifies places where `max_by { ... }`, `min_by { ... }`, or
`minmax_by { ... }` can be replaced by `max`, `min`, or `minmax`.

# Examples

```ruby
# bad
array.max_by { |x| x }
array.min_by { |x| x }
array.minmax_by { |x| x }

# good
array.max
array.min
array.minmax
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantMinMaxBy)