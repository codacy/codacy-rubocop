
Enforces consistent style for empty class definitions.

This cop can enforce either a standard class definition or `Class.new`
for classes with no body.

The supported styles are:

* class_keyword (default) - prefer standard class definition over `Class.new`
* class_new - prefer `Class.new` over class definition

One difference between the two styles is that the `Class.new` form does not make
the subclass name available to the base class's `inherited` callback.
For this reason, `EnforcedStyle: class_keyword` is set as the default style.
Class definitions without a superclass, which are not involved in inheritance,
are not detected. This ensures safe detection regardless of the applied style.
This avoids overlapping responsibilities with the `Lint/EmptyClass` cop.

Use `AllowedParentClasses` to permit both styles for specific parent classes.
For example, adding `StandardError` allows both `Error = Class.new(StandardError)`
and `class Error < StandardError; end` regardless of the enforced style.

# Examples

```ruby
# bad
FooError = Class.new(StandardError)

# okish
class FooError < StandardError; end

# good
class FooError < StandardError
end# bad
class FooError < StandardError
end

# bad
class FooError < StandardError; end

# good
FooError = Class.new(StandardError)# good - allowed regardless of EnforcedStyle
FooError = Class.new(StandardError)

# good - allowed regardless of EnforcedStyle
class FooError < StandardError
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EmptyClassDefinition)