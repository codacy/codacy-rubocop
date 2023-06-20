
Checks for places where custom logic on rejection nils from arrays
and hashes can be replaced with `{Array,Hash}#{compact,compact!}`.

# Examples

```ruby
# bad
array.reject(&:nil?)
array.delete_if(&:nil?)
array.reject { |e| e.nil? }
array.delete_if { |e| e.nil? }
array.select { |e| !e.nil? }

# good
array.compact

# bad
hash.reject!(&:nil?)
hash.reject! { |k, v| v.nil? }
hash.select! { |k, v| !v.nil? }

# good
hash.compact!# good
params.reject(&:nil?)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CollectionCompact)