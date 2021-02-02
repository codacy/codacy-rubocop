
This cop enforces the use of `collection.exclude?(obj)`
over `!collection.include?(obj)`.

It is marked as unsafe by default because false positive will occur for
a receiver object that do not have `exclude?` method. (e.g. `IPAddr`)

# Examples

```ruby
# bad
!array.include?(2)
!hash.include?(:key)

# good
array.exclude?(2)
hash.exclude?(:key)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/NegateInclude)