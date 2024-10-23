
Checks for the use of Ruby Refinements library. Refinements add
complexity and incur a performance penalty that can be significant
for large code bases. Good examples are cases of unrelated
methods that happen to have the same name as these module methods.

# Examples

```ruby
# bad
module Foo
  refine(Date) do
  end
end

# bad
module Foo
  using(Date) do
  end
end

# good
module Foo
  bar.refine(Date)
end

# good
module Foo
  bar.using(Date)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/Refinement)