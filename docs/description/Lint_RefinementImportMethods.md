
Checks if `include` or `prepend` is called in `refine` block.
These methods are deprecated and should be replaced with `Refinement#import_methods`.

It emulates deprecation warnings in Ruby 3.1.

# Examples

```ruby

# bad
refine Foo do
  include Bar
end

# bad
refine Foo do
  prepend Bar
end

# good
refine Foo do
  import_methods Bar
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/RefinementImportMethods)