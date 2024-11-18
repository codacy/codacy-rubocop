
Checks for duplicate literal, constant, or variable elements in Set.

# Examples

```ruby

# bad
Set[:foo, :bar, :foo]

# good
Set[:foo, :bar]

# bad
Set.new([:foo, :bar, :foo])

# good
Set.new([:foo, :bar])

# bad
[:foo, :bar, :foo].to_set

# good
[:foo, :bar].to_set
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DuplicateSetElement)