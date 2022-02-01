
Prefer using `Hash#compare_by_identity` rather than using `object_id`
for hash keys.

This cop looks for hashes being keyed by objects' `object_id`, using
one of these methods: `key?`, `has_key?`, `fetch`, `[]` and `[]=`.

# Examples

```ruby
# bad
hash = {}
hash[foo.object_id] = :bar
hash.key?(baz.object_id)

# good
hash = {}.compare_by_identity
hash[foo] = :bar
hash.key?(baz)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/HashCompareByIdentity)