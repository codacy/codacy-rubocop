
This cop looks for uses of flip flop operator

# Examples

```ruby
# bad
(1..20).each do |x|
  puts x if (x == 5) .. (x == 10)
end

# good
(1..20).each do |x|
  puts x if (x >= 5) && (x <= 10)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/FlipFlop)