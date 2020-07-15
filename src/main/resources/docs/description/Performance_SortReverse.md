
This cop identifies places where `sort { |a, b| b <=> a }`
can be replaced by a faster `sort.reverse`.

# Examples

```ruby
# bad
array.sort { |a, b| b <=> a }

# good
array.sort.reverse
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/SortReverse)