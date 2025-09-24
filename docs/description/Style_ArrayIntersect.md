
In Ruby 3.1, `Array#intersect?` has been added.

This cop identifies places where:

* `(array1 & array2).any?`
* `(array1.intersection(array2)).any?`
* `array1.any? { |elem| array2.member?(elem) }`
* `(array1 & array2).count > 0`
* `(array1 & array2).size > 0`

can be replaced with `array1.intersect?(array2)`.

`array1.intersect?(array2)` is faster and more readable.

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

# bad
array1.any? { |elem| array2.member?(elem) }
array1.none? { |elem| array2.member?(elem) }

# good
array1.intersect?(array2)
!array1.intersect?(array2)

# bad
(array1 & array2).count > 0
(array1 & array2).count.positive?
(array1 & array2).count != 0

(array1 & array2).count == 0
(array1 & array2).count.zero?

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