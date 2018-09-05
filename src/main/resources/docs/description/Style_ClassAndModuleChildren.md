
This cop checks the style of children definitions at classes and
modules. Basically there are two different styles:

The compact style is only forced for classes/modules with one child.

# Examples

```ruby
# good
# have each child on its own line
class Foo
  class Bar
  end
end# good
# combine definitions as much as possible
class Foo::Bar
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ClassAndModuleChildren)