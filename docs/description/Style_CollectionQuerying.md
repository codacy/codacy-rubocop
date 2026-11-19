
Prefer `Enumerable` predicate methods over expressions with `count`.

The cop checks calls to `count` without arguments, or with a
block. It doesn't register offenses for `count` with a positional
argument because its behavior differs from predicate methods (`count`
matches the argument using `==`, while `any?`, `none?` and `one?` use
`===`).

NOTE: This cop doesn't check `length` and `size` methods because they
would yield false positives. For example, `String` implements `length`
and `size`, but it doesn't include `Enumerable`.

When `count` is used without a block, it measures the collection's
size, so the offense is corrected to `empty?` or `!empty?`. The
predicate methods `any?`, `none?` and `one?` test element truthiness
instead and would return different results for collections with falsey
elements (e.g. `[false].count.zero?` is `false`, but `[false].none?`
is `true`). For the same reason, `count == 1` and `count > 1` without
a block are not flagged.

# Examples

```ruby

# bad
x.count.positive?
x.count > 0
x.count != 0

# good
!x.empty?

# bad
x.count(&:foo?).positive?
x.count { |item| item.foo? }.positive?

# good
x.any?(&:foo?)
x.any? { |item| item.foo? }

# bad
x.count.zero?
x.count == 0

# good
x.empty?

# bad
x.count(&:foo?).zero?
x.count(&:foo?) == 0

# good
x.none?(&:foo?)

# bad
x.count(&:foo?) == 1

# good
x.one?(&:foo?)


# good
x.count(&:foo?) > 1


# bad
x.count(&:foo?) > 1

# good
x.many?(&:foo?)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CollectionQuerying)