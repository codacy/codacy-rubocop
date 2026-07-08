
Forbids `extend T::Sig` and `include T::Sig` in classes and modules.

This is useful when using RBS or RBS-inline syntax for type signatures,
where `T::Sig` is not needed and including it is redundant.

# Examples

```ruby

# bad
class Example
  extend T::Sig
end

# bad
module Example
  include T::Sig
end

# good
class Example
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTSig)