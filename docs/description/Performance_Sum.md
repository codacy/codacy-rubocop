
This cop identifies places where custom code finding the sum of elements
in some Enumerable object can be replaced by `Enumerable#sum` method.

This cop can change auto-correction scope depending on the value of
`SafeAutoCorrect`.
Its auto-correction is marked as safe by default (`SafeAutoCorrect: true`)
to prevent `TypeError` in auto-correced code when initial value is not
specified as shown below:

[source,ruby]
----
['a', 'b'].sum # => (String can't be coerced into Integer)
----

Therefore if initial value is not specified, unsafe auto-corrected will not occur.

If you always want to enable auto-correction, you can set `SafeAutoCorrect: false`.

[source,yaml]
----
Performance/Sum:
  SafeAutoCorrect: false
----

Please note that the auto-correction command line option will be changed from
`rubocop -a` to `rubocop -A`, which includes unsafe auto-correction.

# Examples

```ruby
# bad
[1, 2, 3].inject(:+)                        # These bad cases with no initial value are unsafe and
[1, 2, 3].inject(&:+)                       # will not be auto-correced by default. If you want to
[1, 2, 3].reduce { |acc, elem| acc + elem } # auto-corrected, you can set `SafeAutoCorrect: false`.
[1, 2, 3].reduce(10, :+)
[1, 2, 3].map { |elem| elem ** 2 }.sum
[1, 2, 3].collect(&:count).sum(10)

# good
[1, 2, 3].sum
[1, 2, 3].sum(10)
[1, 2, 3].sum { |elem| elem ** 2 }
[1, 2, 3].sum(10, &:count)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/Sum)