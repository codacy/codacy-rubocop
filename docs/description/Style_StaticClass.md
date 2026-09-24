
Checks for places where classes with only class methods can be
replaced with a module. Classes should be used only when it makes sense to create
instances out of them.

When `AllCops/UseProjectIndex` is enabled and the `rubydex` gem is
installed, classes that are subclassed anywhere in the project are
not reported, since converting them to modules would break their
subclasses.

# Examples

```ruby
# bad
class SomeClass
  def self.some_method
    # body omitted
  end

  def self.some_other_method
    # body omitted
  end
end

# good
module SomeModule
  module_function

  def some_method
    # body omitted
  end

  def some_other_method
    # body omitted
  end
end

# good - has instance method
class SomeClass
  def instance_method; end
  def self.class_method; end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/StaticClass)