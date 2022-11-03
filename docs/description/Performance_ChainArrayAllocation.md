
Identifies usages of `array.compact.flatten.map { |x| x.downcase }`.
Each of these methods (`compact`, `flatten`, `map`) will generate a new intermediate array
that is promptly thrown away. Instead it is faster to mutate when we know it's safe.

# Examples

```ruby
# bad
array = ["a", "b", "c"]
array.compact.flatten.map { |x| x.downcase }

# good
array = ["a", "b", "c"]
array.compact!
array.flatten!
array.map! { |x| x.downcase }
array
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/ChainArrayAllocation)