
Identifies places where `sort { |a, b| a <=> b }` can be replaced with `sort`.

# Examples

```ruby
# bad
array.sort { |a, b| a <=> b }

# good
array.sort
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/RedundantSortBlock)