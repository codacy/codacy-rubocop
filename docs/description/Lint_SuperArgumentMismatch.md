
Checks for `super` calls with explicit arguments that pass the wrong
number of positional arguments to the overridden implementation, using
the project index.

The check is powered by the project-wide index, so it only runs when
`AllCops/UseProjectIndex` is enabled and the `rubydex` gem is installed.
Without the index the cop does nothing.

Only `super` inside a plain instance method defined directly in a class
body is considered, and only when the enclosing class resolves in the
index and its entire ancestry is resolved, so a superclass method coming
from a gem, the standard library, or a dynamic definition never produces
an offense. The overridden implementation is the first ancestor after
the enclosing class in the index's method resolution order that defines
the method; when it is not a plain method definition (an `attr_*` or an
alias) or its definitions disagree on arity, the call is not checked.
Calls that forward arguments (`*`, `**`, `...`) are skipped, and bare
`super` (which forwards the current method's parameters) is not checked.
Methods the index attributes to `Object`, `Kernel`, or `BasicObject`
are never used as the overridden implementation, since a `def` inside
a block at the top level (`Struct.new do ... end`) is indexed under
`Object` even though it defines a method somewhere else entirely.

# Examples

```ruby
# Given the project defines:
#   class Base
#     def initialize(name, size); end
#   end

# bad
class Widget < Base
  def initialize(name)
    super(name)
  end
end

# good
class Widget < Base
  def initialize(name)
    super(name, 0)
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/SuperArgumentMismatch)