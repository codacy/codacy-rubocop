
Checks for useless constant scoping. Private constants must be defined using
`private_constant`. Even if `private` access modifier is used, it is public scope despite
its appearance.

It does not support autocorrection due to behavior change and multiple ways to fix it.
Or a public constant may be intended.

Constant assignments that define classes or modules via `Class.new`, `Module.new`,
`Struct.new`, or `Data.define` are allowed. Those forms are class and module definitions
written with assignment syntax, and match the common practice of placing nested
`class` / `module` bodies after `private` without intending private constant visibility.

# Examples

```ruby

# bad
class Foo
  private
  PRIVATE_CONST = 42
end

# good
class Foo
  PRIVATE_CONST = 42
  private_constant :PRIVATE_CONST
end

# good
class Foo
  PUBLIC_CONST = 42 # If private scope is not intended.
end

# good - class/module definitions via assignment, same as nested `class`/`module`
class Foo
  private

  def some_private_method
  end

  MyClass = Class.new
  MyModule = Module.new
  MyStruct = Struct.new(:name)
  MyData = Data.define(:name)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UselessConstantScoping)