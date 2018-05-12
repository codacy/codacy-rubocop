
This cop checks for interpolation in a single quoted string.

# Examples

```ruby

# bad

foo = 'something with #{interpolation} inside'
# good

foo = "something with #{interpolation} inside"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/InterpolationCheck)