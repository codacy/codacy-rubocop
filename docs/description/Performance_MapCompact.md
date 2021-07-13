
In Ruby 2.7, `Enumerable#filter_map` has been added.

This cop identifies places where `map { ... }.compact` can be replaced by `filter_map`.
It is marked as unsafe auto-correction by default because `map { ... }.compact`
that is not compatible with `filter_map`.

[source,ruby]
----
[true, false, nil].compact              #=> [true, false]
[true, false, nil].filter_map(&:itself) #=> [true]
----

# Examples

```ruby
# bad
ary.map(&:foo).compact
ary.collect(&:foo).compact

# good
ary.filter_map(&:foo)
ary.map(&:foo).compact!
ary.compact.map(&:foo)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/MapCompact)