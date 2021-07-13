
This cop identifies places where `Hash#merge!` can be replaced by
`Hash#[]=`.
You can set the maximum number of key-value pairs to consider
an offense with `MaxKeyValuePairs`.

This cop is marked as unsafe because RuboCop cannot determine if the
receiver of `merge!` is actually a hash or not.

# Examples

```ruby
# bad
hash.merge!(a: 1)
hash.merge!({'key' => 'value'})

# good
hash[:a] = 1
hash['key'] = 'value'# bad
hash.merge!(a: 1, b: 2)

# good
hash[:a] = 1
hash[:b] = 2
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/RedundantMerge)