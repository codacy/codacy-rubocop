
Access modifiers should be declared to apply to a group of methods
or inline before each method, depending on configuration.

# Examples

```ruby

# bad

class Foo

  private def bar; end
  private def baz; end

end

# good

class Foo

  private

  def bar; end
  def baz; end

end
# bad

class Foo

  private

  def bar; end
  def baz; end

end

# good

class Foo

  private def bar; end
  private def baz; end

end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/AccessModifierDeclarations)