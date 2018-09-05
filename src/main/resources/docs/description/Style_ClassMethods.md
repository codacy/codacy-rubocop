
This cop checks for uses of the class/module name instead of
self, when defining class/module methods.

# Examples

```ruby
# bad
class SomeClass
  def SomeClass.class_method
    # ...
  end
end

# good
class SomeClass
  def self.class_method
    # ...
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ClassMethods)