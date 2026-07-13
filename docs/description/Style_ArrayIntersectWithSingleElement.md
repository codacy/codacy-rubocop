
Use `include?(element)` instead of `intersect?([element])`.

# Examples

```ruby
# bad
array.intersect?([element])

# good
array.include?(element)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ArrayIntersectWithSingleElement)