
Checks that namespaced classes and modules are defined with a consistent style.

With `nested` style, classes and modules should be defined separately (one constant
on each line, without `::`). With `compact` style, classes and modules should be
defined with fully qualified names (using `::` for namespaces).

NOTE: The style chosen will affect `Module.nesting` for the class or module. Using
`nested` style will result in each level being added, whereas `compact` style will
only include the fully qualified class or module name.

By default, `EnforcedStyle` applies to both classes and modules. If desired, separate
styles can be defined for classes and modules by using `EnforcedStyleForClasses` and
`EnforcedStyleForModules` respectively. If not set, or set to nil, the `EnforcedStyle`
value will be used.

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