
Checks that arrays are sliced with endless ranges instead of
`ary[start..-1]` on Ruby 2.6+.

# Examples

```ruby
# bad
items[1..-1]

# good
items[1..]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SlicingWithRange)