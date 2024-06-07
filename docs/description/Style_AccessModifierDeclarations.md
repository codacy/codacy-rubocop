
Access modifiers should be declared to apply to a group of methods
or inline before each method, depending on configuration.
EnforcedStyle config covers only method definitions.
Applications of visibility methods to symbols can be controlled
using AllowModifiersOnSymbols config.
Also, the visibility of `attr*` methods can be controlled using
AllowModifiersOnAttrs config.

In Ruby 3.0, `attr*` methods now return an array of defined method names
as symbols. So we can write the modifier and `attr*` in inline style.
AllowModifiersOnAttrs config allows `attr*` methods to be written in
inline style without modifying applications that have been maintained
for a long time in group style. Furthermore, developers who are not very
familiar with Ruby may know that the modifier applies to `def`, but they
may not know that it also applies to `attr*` methods. It would be easier
to understand if we could write `attr*` methods in inline style.

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

end# good
class Foo

  public attr_reader :bar
  protected attr_writer :baz
  private attr_accessor :qux
  private attr :quux

  def public_method; end

  private

  def private_method; end

end# bad
class Foo

  public attr_reader :bar
  protected attr_writer :baz
  private attr_accessor :qux
  private attr :quux

end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/AccessModifierDeclarations)