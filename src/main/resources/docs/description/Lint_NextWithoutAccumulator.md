
Don't omit the accumulator when calling `next` in a `reduce` block.

# Examples

```ruby

# bad

result = (1..4).reduce(0) do |acc, i|
  next if i.odd?
  acc + i
end
# good

result = (1..4).reduce(0) do |acc, i|
  next acc if i.odd?
  acc + i
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/NextWithoutAccumulator)