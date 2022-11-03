
Checks for usage of comparison operators (`==`,
`>`, `<`) to test numbers as zero, positive, or negative.
These can be replaced by their respective predicate methods.
This cop can also be configured to do the reverse.

This cop can be customized allowed methods with `AllowedMethods`.
By default, there are no methods to allowed.

This cop disregards `#nonzero?` as its value is truthy or falsey,
but not `true` and `false`, and thus not always interchangeable with
`!= 0`.

This cop allows comparisons to global variables, since they are often
populated with objects which can be compared with integers, but are
not themselves `Integer` polymorphic.

# Examples

```ruby
# bad
foo == 0
0 > foo
bar.baz > 0

# good
foo.zero?
foo.negative?
bar.baz.positive?# bad
foo.zero?
foo.negative?
bar.baz.positive?

# good
foo == 0
0 > foo
bar.baz > 0# bad
foo == 0
0 > foo
bar.baz > 0# good
foo == 0

# bad
0 > foo
bar.baz > 0# bad
foo.zero?
foo.negative?
bar.baz.positive?# good
# bad
foo.zero?

# bad
foo.negative?
bar.baz.positive?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NumericPredicate)