
Prefer `Enumerable` predicate methods over expressions with `count`.

The cop checks calls to `count` without arguments, or with a
block. It doesn't register offenses for `count` with a positional
argument because its behavior differs from predicate methods (`count`
matches the argument using `==`, while `any?`, `none?` and `one?` use
`===`).

NOTE: This cop doesn't check `length` and `size` methods because they
would yield false positives. For example, `String` implements `length`
and `size`, but it doesn't include `Enumerable`.

# Examples

```ruby

# bad
x.count.positive?
x.count > 0
x.count != 0

x.count(&:foo?).positive?
x.count { |item| item.foo? }.positive?

# good
x.any?

x.any?(&:foo?)
x.any? { |item| item.foo? }

# bad
x.count.zero?
x.count == 0

# good
x.none?

# bad
x.count == 1
x.one?
# good
x.count > 1
# bad
x.count > 1

# good
x.many?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CollectionQuerying)