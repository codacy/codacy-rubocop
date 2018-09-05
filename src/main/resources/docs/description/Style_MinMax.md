
This cop checks for potential uses of `Enumerable#minmax`.

# Examples

```ruby

# bad
bar = [foo.min, foo.max]
return foo.min, foo.max

# good
bar = foo.minmax
return foo.minmax
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MinMax)