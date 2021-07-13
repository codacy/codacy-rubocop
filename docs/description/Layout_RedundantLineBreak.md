
This cop checks whether certain expressions, e.g. method calls, that could fit
completely on a single line, are broken up into multiple lines unnecessarily.

# Examples

```ruby
# bad
foo(
  a,
  b
)

puts 'string that fits on ' \
     'a single line'

things
  .select { |thing| thing.cond? }
  .join('-')

# good
foo(a, b)

puts 'string that fits on a single line'

things.select { |thing| thing.cond? }.join('-')# good
foo(a) do |x|
  puts x
end# bad
foo(a) do |x|
  puts x
end

# good
foo(a) { |x| puts x }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/RedundantLineBreak)