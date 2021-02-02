
This cop checks for using Fixnum or Bignum constant.

# Examples

```ruby

# bad

1.is_a?(Fixnum)
1.is_a?(Bignum)
# good

1.is_a?(Integer)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UnifiedInteger)