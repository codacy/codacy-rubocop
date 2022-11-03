
Identifies places where slicing arrays with semi-infinite ranges
can be replaced by `Array#take` and `Array#drop`.
This cop was created due to a mistake in microbenchmark and hence is disabled by default.
Refer https://github.com/rubocop/rubocop-performance/pull/175#issuecomment-731892717

# Examples

```ruby
# bad
array[..2]
array[...2]
array[2..]
array[2...]
array.slice(..2)

# good
array.take(3)
array.take(2)
array.drop(2)
array.drop(2)
array.take(3)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/ArraySemiInfiniteRangeSlice)