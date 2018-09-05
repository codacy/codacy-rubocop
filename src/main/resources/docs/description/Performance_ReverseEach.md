
This cop is used to identify usages of `reverse.each` and
change them to use `reverse_each` instead.

# Examples

```ruby
# bad
[].reverse.each

# good
[].reverse_each
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/ReverseEach)