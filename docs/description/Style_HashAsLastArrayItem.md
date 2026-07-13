
Checks for presence or absence of braces around hash literal as a last
array item depending on configuration.

NOTE: This cop will ignore arrays where multiple items are all hashes,
regardless of `EnforcedStyle`.

[source,ruby]
----
[{ one: 1 }, { two: 2 }]
----

# Examples

```ruby
# bad
[1, 2, one: 1, two: 2]

# good
[1, 2, { one: 1, two: 2 }]

# bad
[one: 1, two: 2]

# good
[{ one: 1, two: 2 }]

# bad
[1, 2, { one: 1, two: 2 }]

# good
[1, 2, one: 1, two: 2]

# bad
[{ one: 1, two: 2 }]

# good
[one: 1, two: 2]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/HashAsLastArrayItem)