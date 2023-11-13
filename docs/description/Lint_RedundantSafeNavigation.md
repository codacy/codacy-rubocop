
Checks for redundant safe navigation calls.
Use cases where a constant, named in camel case for classes and modules is `nil` are rare,
and an offense is not detected when the receiver is a snake case constant.

For all receivers, the `instance_of?`, `kind_of?`, `is_a?`, `eql?`, `respond_to?`,
and `equal?` methods are checked by default.
These are customizable with `AllowedMethods` option.

The `AllowedMethods` option specifies nil-safe methods,
in other words, it is a method that is allowed to skip safe navigation.
Note that the `AllowedMethod` option is not an option that specifies methods
for which to suppress (allow) this cop's check.

In the example below, the safe navigation operator (`&.`) is unnecessary
because `NilClass` has methods like `respond_to?` and `is_a?`.

# Examples

```ruby
# bad
CamelCaseConst&.do_something

# bad
do_something if attrs&.respond_to?(:[])

# good
do_something if attrs.respond_to?(:[])

# bad
while node&.is_a?(BeginNode)
  node = node.parent
end

# good
CamelCaseConst.do_something

# good
while node.is_a?(BeginNode)
  node = node.parent
end

# good - without `&.` this will always return `true`
foo&.respond_to?(:to_a)# bad
do_something if attrs&.nil_safe_method(:[])

# good
do_something if attrs.nil_safe_method(:[])
do_something if attrs&.not_nil_safe_method(:[])
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/RedundantSafeNavigation)