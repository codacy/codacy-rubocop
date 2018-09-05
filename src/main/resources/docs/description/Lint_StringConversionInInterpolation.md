
This cop checks for string conversion in string interpolation,
which is redundant.

# Examples

```ruby

# bad

"result is #{something.to_s}"
# good

"result is #{something}"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/StringConversionInInterpolation)