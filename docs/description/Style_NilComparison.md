
Checks for comparison of something with nil using `==` and
`nil?`. Enforcing a consistent style (either the `nil?`
predicate or `==` comparison) improves readability.

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