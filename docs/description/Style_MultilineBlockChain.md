
This cop checks for chaining of a block after another block that spans
multiple lines.

# Examples

```ruby

# bad
Thread.list.select do |t|
  t.alive?
end.map do |t|
  t.object_id
end

# good
alive_threads = Thread.list.select do |t|
  t.alive?
end
alive_threads.map do |t|
  t.object_id
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MultilineBlockChain)