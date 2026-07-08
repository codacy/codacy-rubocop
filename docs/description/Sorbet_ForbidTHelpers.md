
Forbids `extend T::Helpers` and `include T::Helpers` in classes and modules.

This is useful when using RBS or RBS-inline syntax for type signatures,
where `T::Helpers` is not needed and including it is redundant.

# Examples

```ruby

# bad
class Example
  extend T::Helpers
end

# bad
module Example
  include T::Helpers
end

# good
class Example
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTHelpers)