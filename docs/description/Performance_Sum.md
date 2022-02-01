
This cop identifies places where custom code finding the sum of elements
in some Enumerable object can be replaced by `Enumerable#sum` method.

# Examples

```ruby
# bad
[1, 2, 3].inject(:+)                        # Auto-corrections for cases without initial value are unsafe
[1, 2, 3].inject(&:+)                       # and will only be performed when using the `-A` option.
[1, 2, 3].reduce { |acc, elem| acc + elem } # They can be prohibited completely using `SafeAutoCorrect: true`.
[1, 2, 3].reduce(10, :+)
[1, 2, 3].map { |elem| elem ** 2 }.sum
[1, 2, 3].collect(&:count).sum(10)

# good
[1, 2, 3].sum
[1, 2, 3].sum(10)
[1, 2, 3].sum { |elem| elem ** 2 }
[1, 2, 3].sum(10, &:count)# bad
[1, 2, 3].reduce(10, :+)
[1, 2, 3].map { |elem| elem ** 2 }.sum
[1, 2, 3].collect(&:count).sum(10)

# good
[1, 2, 3].sum(10)
[1, 2, 3].sum { |elem| elem ** 2 }
[1, 2, 3].sum(10, &:count)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/Sum)