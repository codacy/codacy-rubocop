
Disallow including the `Comparable` module in `T::Enum`.

# Examples

```ruby

# bad
class Priority < T::Enum
  include Comparable

  enums do
    High = new(3)
    Medium = new(2)
    Low = new(1)
  end

  def <=>(other)
    serialize <=> other.serialize
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidComparableTEnum)