##Class variables usage

Avoid using class variables since they have some nasty behaviour in inheritance

**Example:**

```
class Parent
  @@class_var = 'parent'

  def self.print_class_var
    puts @@class_var
  end
end

class Child < Parent
  @@class_var = 'child'
end

Parent.print_class_var # => will print "child"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ClassVars)
