
Checks for `each_with_object`, `inject`, and `reduce` calls that build
a hash from an enumerable, where `to_h` with a block could be used instead.

This cop complements `Style/HashTransformKeys` and `Style/HashTransformValues`,
which handle hash-to-hash transformations with destructured key-value pairs.
This cop targets the case where a hash is built from individual elements
(non-destructured block parameter).

# Examples

```ruby
# bad
array.each_with_object({}) { |elem, hash| hash[elem.id] = elem.name }

# bad
array.inject({}) { |hash, elem| hash[elem.id] = elem.name; hash }

# bad
array.reduce({}) { |hash, elem| hash[elem.id] = elem.name; hash }

# bad
array.each_with_object({}) { |elem, hash| hash[elem] = elem.to_s }

# good
array.to_h { |elem| [elem.id, elem.name] }

# good
array.to_h { |elem| [elem, elem.to_s] }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ReduceToHash)