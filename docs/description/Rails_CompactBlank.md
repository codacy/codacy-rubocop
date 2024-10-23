
Checks if collection can be blank-compacted with `compact_blank`.

# Examples

```ruby

# bad
collection.reject(&:blank?)
collection.reject { |_k, v| v.blank? }
collection.select(&:present?)
collection.select { |_k, v| v.present? }
collection.filter(&:present?)
collection.filter { |_k, v| v.present? }

# good
collection.compact_blank

# bad
collection.delete_if(&:blank?)            # Same behavior as `Array#compact_blank!` and `Hash#compact_blank!`
collection.delete_if { |_k, v| v.blank? } # Same behavior as `Array#compact_blank!` and `Hash#compact_blank!`
collection.keep_if(&:present?)            # Same behavior as `Array#compact_blank!` and `Hash#compact_blank!`
collection.keep_if { |_k, v| v.present? } # Same behavior as `Array#compact_blank!` and `Hash#compact_blank!`

# good
collection.compact_blank!
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/CompactBlank)