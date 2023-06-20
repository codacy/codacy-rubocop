
Checks for string conversion in string interpolation, `print`, `puts`, and `warn` arguments,
which is redundant.

# Examples

```ruby

# bad

"result is #{something.to_s}"
print something.to_s
puts something.to_s
warn something.to_s
# good

"result is #{something}"
print something
puts something
warn something
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/RedundantStringCoercion)