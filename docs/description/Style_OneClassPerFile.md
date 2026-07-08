
Checks that each source file defines at most one top-level class or module.

Keeping one class or module per file makes it easier to find and navigate
code, and follows the convention used by most Ruby projects.

Classes and modules listed in `AllowedClasses` are not counted toward the
limit. This is useful for small ancillary classes like custom exception
classes that logically belong with the main class.

# Examples

```ruby
# bad - Multiple top-level classes
class Foo
end

class Bar
end

# bad - Multiple top-level modules
module Foo
end

module Bar
end

# bad - A top-level class and a top-level module
class Foo
end

module Bar
end

# good - A single top-level class
class Foo
end

# good - A single top-level module
module Foo
end

# good - Nested classes within a single top-level class
class Foo
  class Bar
  end
end

# good - Multiple classes within a single top-level module
module Foo
  class Bar
  end

  class Baz
  end
end# good
class Foo
end

class AllowedClass
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/OneClassPerFile)