
This cop ensures one ancestor per requires_ancestor line
rather than chaining them as a comma-separated list.

# Examples

```ruby

# bad
module SomeModule
  requires_ancestor Kernel, Minitest::Assertions
end

# good
module SomeModule
  requires_ancestor Kernel
  requires_ancestor Minitest::Assertions
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/OneAncestorPerLine)