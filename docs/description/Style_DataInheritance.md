
Checks for inheritance from `Data.define` to avoid creating the anonymous parent class.
Inheriting from `Data.define` adds a superfluous level in inheritance tree.

# Examples

```ruby
# bad
class Person < Data.define(:first_name, :last_name)
  def age
    42
  end
end

Person.ancestors
# => [Person, #<Class:0x000000010b4e14a0>, Data, (...)]

# good
Person = Data.define(:first_name, :last_name) do
  def age
    42
  end
end

Person.ancestors
# => [Person, Data, (...)]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/DataInheritance)