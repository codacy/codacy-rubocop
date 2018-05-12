
This cop identifies Float literals which are, like, really really really
really really really really really big. Too big. No-one needs Floats
that big. If you need a float that big, something is wrong with you.

# Examples

```ruby

# bad

float = 3.0e400
# good

float = 42.9
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/FloatOutOfRange)