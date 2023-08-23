
Checks for inheritance from `Data.define` to avoid creating the anonymous parent class.

# Examples

```ruby
# bad
class Person < Data.define(:first_name, :last_name)
  def age
    42
  end
end

# good
Person = Data.define(:first_name, :last_name) do
  def age
    42
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/DataInheritance)