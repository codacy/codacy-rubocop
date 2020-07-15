
This cop is used to identify usages of `count` on an
`Array` and `Hash` and change them to `size`.

TODO: Add advanced detection of variables that could
have been assigned to an array or a hash.

# Examples

```ruby
# bad
[1, 2, 3].count
(1..3).to_a.count
Array[*1..3].count
Array(1..3).count

# bad
{a: 1, b: 2, c: 3}.count
[[:foo, :bar], [1, 2]].to_h.count
Hash[*('a'..'z')].count
Hash(key: :value).count

# good
[1, 2, 3].size
(1..3).to_a.size
Array[*1..3].size
Array(1..3).size

# good
{a: 1, b: 2, c: 3}.size
[[:foo, :bar], [1, 2]].to_h.size
Hash[*('a'..'z')].size
Hash(key: :value).size

# good
[1, 2, 3].count { |e| e > 2 }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/Size)