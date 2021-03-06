
This cop checks for the presence of constructors and lifecycle callbacks
without calls to `super`.

This cop does not consider `method_missing` (and `respond_to_missing?`)
because in some cases it makes sense to overtake what is considered a
missing method. In other cases, the theoretical ideal handling could be
challenging or verbose for no actual gain.

# Examples

```ruby
# bad
class Employee < Person
  def initialize(name, salary)
    @salary = salary
  end
end

# good
class Employee < Person
  def initialize(name, salary)
    super(name)
    @salary = salary
  end
end

# bad
class Parent
  def self.inherited(base)
    do_something
  end
end

# good
class Parent
  def self.inherited(base)
    super
    do_something
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/MissingSuper)