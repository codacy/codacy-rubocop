
Checks for places where custom logic on rejection nils from arrays
and hashes can be replaced with `{Array,Hash}#{compact,compact!}`.

# Examples

```ruby
# bad
array.reject(&:nil?)
array.reject { |e| e.nil? }
array.select { |e| !e.nil? }
array.filter { |e| !e.nil? }
array.grep_v(nil)
array.grep_v(NilClass)

# good
array.compact

# bad
hash.reject!(&:nil?)
hash.reject! { |k, v| v.nil? }
hash.select! { |k, v| !v.nil? }
hash.filter! { |k, v| !v.nil? }

# good
hash.compact!# good
params.reject(&:nil?)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CollectionCompact)