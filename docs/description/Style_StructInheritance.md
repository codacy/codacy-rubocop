
Checks for inheritance from `Struct.new`. Inheriting from `Struct.new`
adds a superfluous level in inheritance tree.

# Examples

```ruby
# bad
class Person < Struct.new(:first_name, :last_name)
  def age
    42
  end
end

Person.ancestors
# => [Person, #<Class:0x000000010b4e14a0>, Struct, (...)]

# good
Person = Struct.new(:first_name, :last_name) do
  def age
    42
  end
end

Person.ancestors
# => [Person, Struct, (...)]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/StructInheritance)