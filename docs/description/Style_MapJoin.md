
Checks for `map { |x| x.to_s }.join` and similar calls where the
`map` is redundant because `Array#join` implicitly calls `#to_s` on
each element.

# Examples

```ruby
# bad
array.map(&:to_s).join(', ')

# bad
array.map { |x| x.to_s }.join(', ')

# bad
array.collect(&:to_s).join

# good
array.join(', ')

# good
array.join
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MapJoin)