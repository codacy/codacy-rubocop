
This cop checks for chaining of a block after another block that spans
multiple lines.

# Examples

```ruby

Thread.list.find_all do |t|
  t.alive?
end.map do |t|
  t.object_id
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MultilineBlockChain)