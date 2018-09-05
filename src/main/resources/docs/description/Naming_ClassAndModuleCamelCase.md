
This cops checks for class and module names with
an underscore in them.

# Examples

```ruby
# bad
class My_Class
end
module My_Module
end

# good
class MyClass
end
module MyModule
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/ClassAndModuleCamelCase)