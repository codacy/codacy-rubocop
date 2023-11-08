
Disallow using `T::Struct` and `T::Props`.

# Examples

```ruby

# bad
class MyStruct < T::Struct
  const :foo, String
  prop :bar, Integer, default: 0

  def some_method; end
end

# good
class MyStruct
  extend T::Sig

  sig { returns(String) }
  attr_reader :foo

  sig { returns(Integer) }
  attr_accessor :bar

  sig { params(foo: String, bar: Integer) }
  def initialize(foo:, bar: 0)
    @foo = foo
    @bar = bar
  end

  def some_method; end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTStruct)