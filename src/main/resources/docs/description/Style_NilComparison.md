
This cop checks for comparison of something with nil using ==.

# Examples

```ruby

# bad
if x == nil
end

# good
if x.nil?
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NilComparison)