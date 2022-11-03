
Identifies usages of `reverse.each` and change them to use `reverse_each` instead.

If the return value is used, it will not be detected because the result will be different.

[source,ruby]
----
[1, 2, 3].reverse.each {} #=> [3, 2, 1]
[1, 2, 3].reverse_each {} #=> [1, 2, 3]
----

# Examples

```ruby
# bad
items.reverse.each

# good
items.reverse_each
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/ReverseEach)