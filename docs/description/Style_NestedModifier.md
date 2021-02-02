
This cop checks for nested use of if, unless, while and until in their
modifier form.

# Examples

```ruby

# bad
something if a if b

# good
something if b && a
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NestedModifier)