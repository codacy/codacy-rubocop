
Checks for chained `dig` calls that can be collapsed into a single `dig`.

# Examples

```ruby
# bad
x.dig(:foo).dig(:bar).dig(:baz)
x.dig(:foo, :bar).dig(:baz)
x.dig(:foo, :bar)&.dig(:baz)

# good
x.dig(:foo, :bar, :baz)

# good - `dig`s cannot be combined
x.dig(:foo).bar.dig(:baz)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/DigChain)