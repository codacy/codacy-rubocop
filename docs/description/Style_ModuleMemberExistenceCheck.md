
Checks for usage of `Module` methods returning arrays that can be replaced
with equivalent predicates.

Calling a method returning an array then checking if an element is inside
it is much slower than using an equivalent predicate method. For example,
`instance_methods.include?` will return an array of all public and protected
instance methods in the module, then check if a given method is inside that
array, while `method_defined?` will do direct method lookup, which is much
faster and consumes less memory.

NOTE: `constants.include?` is not handled by this cop because
`Module#const_defined?` has different lookup behavior than
`Module#constants` - `const_defined?` searches up to `Object`
(top-level constants like `String`, `Integer`, etc.) while
`constants` does not, which can cause behavior changes after autocorrection.

# Examples

```ruby
# bad
Array.instance_methods.include?(:size)
Array.instance_methods.member?(:size)
Array.instance_methods(true).include?(:size)

Array.instance_methods(false).include?(:find)

# good
Array.method_defined?(:size)

Array.method_defined?(:find, false)

# bad
Array.class_variables.include?(:foo)
Array.private_instance_methods.include?(:foo)
Array.protected_instance_methods.include?(:foo)
Array.public_instance_methods.include?(:foo)

# good
Array.class_variable_defined?(:foo)
Array.private_method_defined?(:foo)
Array.protected_method_defined?(:foo)
Array.public_method_defined?(:foo)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ModuleMemberExistenceCheck)