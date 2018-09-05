
This cop checks for inheritance from Struct.new.

# Examples

```ruby
# bad
class Person < Struct.new(:first_name, :last_name)
end

# good
Person = Struct.new(:first_name, :last_name)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/StructInheritance)