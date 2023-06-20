
Looks for uses of `map.to_set` or `collect.to_set` that could be
written with just `to_set`.

# Examples

```ruby
# bad
something.map { |i| i * 2 }.to_set

# good
something.to_set { |i| i * 2 }

# bad
[1, 2, 3].collect { |i| i.to_s }.to_set

# good
[1, 2, 3].to_set { |i| i.to_s }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MapToSet)