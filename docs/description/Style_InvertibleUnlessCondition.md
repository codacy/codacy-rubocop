
Checks for usages of `unless` which can be replaced by `if` with inverted condition.
Code without `unless` is easier to read, but that is subjective, so this cop
is disabled by default.

Methods that can be inverted should be defined in `InverseMethods`. Note that
the relationship of inverse methods needs to be defined in both directions.
For example,

[source,yaml]
----
InverseMethods:
  :!=: :==
  :even?: :odd?
  :odd?: :even?
----

will suggest both `even?` and `odd?` to be inverted, but only `!=` (and not `==`).

# Examples

```ruby
# bad (simple condition)
foo unless !bar
foo unless x != y
foo unless x >= 10
foo unless x.even?

# good
foo if bar
foo if x == y
foo if x < 10
foo if x.odd?

# bad (complex condition)
foo unless x != y || x.even?

# good
foo if x == y && x.odd?

# good (if)
foo if !condition
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/InvertibleUnlessCondition)