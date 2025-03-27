
In Ruby 3.1, `Array#intersect?` has been added.

This cop identifies places where `(array1 & array2).any?`
or `(array1.intersection(array2)).any?` can be replaced by
`array1.intersect?(array2)`.

The `array1.intersect?(array2)` method is faster than
`(array1 & array2).any?` and is more readable.

In cases like the following, compatibility is not ensured,
so it will not be detected when using block argument.

[source,ruby]
----
([1] & [1,2]).any? { |x| false }    # => false
[1].intersect?([1,2]) { |x| false } # => true
----

NOTE: Although `Array#intersection` can take zero or multiple arguments,
only cases where exactly one argument is provided can be replaced with
`Array#intersect?` and are handled by this cop.

# Examples

```ruby
# bad
(array1 & array2).any?
(array1 & array2).empty?
(array1 & array2).none?

# bad
array1.intersection(array2).any?
array1.intersection(array2).empty?
array1.intersection(array2).none?

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