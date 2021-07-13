
This cop checks if method calls are chained onto single line blocks. It considers that a
line break before the dot improves the readability of the code.

# Examples

```ruby
# bad
example.select { |item| item.cond? }.join('-')

# good
example.select { |item| item.cond? }
       .join('-')

# good (not a concern for this cop)
example.select do |item|
  item.cond?
end.join('-')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SingleLineBlockChain)