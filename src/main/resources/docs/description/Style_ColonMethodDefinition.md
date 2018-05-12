
This cop checks for class methods that are defined using the `::`
operator instead of the `.` operator.

# Examples

```ruby
# bad
class Foo
  def self::bar
  end
end

# good
class Foo
  def self.bar
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ColonMethodDefinition)