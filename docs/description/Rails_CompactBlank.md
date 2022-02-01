
Checks if collection can be blank-compacted with `compact_blank`.

# Examples

```ruby

# bad
collection.reject(&:blank?)
collection.reject { |_k, v| v.blank? }

# good
collection.compact_blank

# bad
collection.reject!(&:blank?)
collection.reject! { |_k, v| v.blank? }

# good
collection.compact_blank!
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/CompactBlank)