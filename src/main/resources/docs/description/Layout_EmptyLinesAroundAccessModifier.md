
Access modifiers should be surrounded by blank lines.

# Examples

```ruby

# bad
class Foo
  def bar; end
  private
  def baz; end
end

# good
class Foo
  def bar; end

  private

  def baz; end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyLinesAroundAccessModifier)