
This cop checks for trailing code after the class definition.

# Examples

```ruby
# bad
class Foo; def foo; end
end

# good
class Foo
  def foo; end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TrailingBodyOnClass)