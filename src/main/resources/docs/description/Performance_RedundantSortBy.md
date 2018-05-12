
This cop identifies places where `sort_by { ... }` can be replaced by
`sort`.

# Examples

```ruby
# bad
array.sort_by { |x| x }
array.sort_by do |var|
  var
end

# good
array.sort
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/RedundantSortBy)