
Avoid redundant `::` prefix on a constant.

How Ruby searches constants is a bit complicated, and it can often be difficult to
understand from the code whether the `::` is intended or not. Where `Module.nesting`
is empty, there is no need to prepend `::`, so it would be nice to consistently
avoid such meaningless `::` prefix to avoid confusion.

NOTE: This cop is disabled if `Lint/ConstantResolution` cop is enabled,
to prevent conflicting rules. This is because it respects user configurations
that want to enable `Lint/ConstantResolution` cop which is disabled by default.

# Examples

```ruby
# bad
::Const

# good
Const

# bad
class << self
  ::Const
end

# good
class << self
  Const
end

# good
class A
  ::Const
end

# good
module A
  ::Const
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantConstantBase)