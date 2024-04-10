
In Ruby 3.1, `Array#intersect?` has been added.

This cop identifies places where `(array1 & array2).any?`
can be replaced by `array1.intersect?(array2)`.

The `array1.intersect?(array2)` method is faster than
`(array1 & array2).any?` and is more readable.

# Examples

```ruby
# bad
(array1 & array2).any?
(array1 & array2).empty?

# good
array1.intersect?(array2)
!array1.intersect?(array2)# good
(array1 & array2).present?
(array1 & array2).blank?# bad
(array1 & array2).present?
(array1 & array2).blank?

# good
array1.intersect?(array2)
!array1.intersect?(array2)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ArrayIntersect)