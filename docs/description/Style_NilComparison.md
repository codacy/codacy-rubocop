
Checks for comparison of something with nil using `==` and
`nil?`.

Supported styles are: predicate, comparison.

# Examples

```ruby

# bad
if x == nil
end

# good
if x.nil?
end
# bad
if x.nil?
end

# good
if x == nil
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NilComparison)