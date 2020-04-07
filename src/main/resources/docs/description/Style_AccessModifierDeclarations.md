
Access modifiers should be declared to apply to a group of methods
or inline before each method, depending on configuration.
EnforcedStyle config covers only method definitions.
Applications of visibility methods to symbols can be controlled
using AllowModifiersOnSymbols config.

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

end# bad
class Foo

  private

  def bar; end
  def baz; end

end

# good
class Foo

  private def bar; end
  private def baz; end

end# good
class Foo

  private :bar, :baz

end# bad
class Foo

  private :bar, :baz

end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/AccessModifierDeclarations)