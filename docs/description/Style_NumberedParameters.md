
This cop checks for numbered parameters.

It can either restrict the use of numbered parameters to
single-lined blocks, or disallow completely numbered parameters.

# Examples

```ruby
# bad
collection.each do
  puts _1
end

# good
collection.each { puts _1 }# bad
collection.each { puts _1 }

# good
collection.each { |item| puts item }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NumberedParameters)