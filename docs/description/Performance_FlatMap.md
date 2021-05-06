
This cop is used to identify usages of `map { ... }.flatten` and
change them to use `flat_map { ... }` instead.

# Examples

```ruby
# bad
[1, 2, 3, 4].map { |e| [e, e] }.flatten(1)
[1, 2, 3, 4].collect { |e| [e, e] }.flatten(1)

# good
[1, 2, 3, 4].flat_map { |e| [e, e] }
[1, 2, 3, 4].map { |e| [e, e] }.flatten
[1, 2, 3, 4].collect { |e| [e, e] }.flatten
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/FlatMap)