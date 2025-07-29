
Checks for redundant safe navigation calls.
Use cases where a constant, named in camel case for classes and modules is `nil` are rare,
and an offense is not detected when the receiver is a constant. The detection also applies
to `self`, and to literal receivers, except for `nil`.

For all receivers, the `instance_of?`, `kind_of?`, `is_a?`, `eql?`, `respond_to?`,
and `equal?` methods are checked by default.
These are customizable with `AllowedMethods` option.

The `AllowedMethods` option specifies nil-safe methods,
in other words, it is a method that is allowed to skip safe navigation.
Note that the `AllowedMethod` option is not an option that specifies methods
for which to suppress (allow) this cop's check.

In the example below, the safe navigation operator (`&.`) is unnecessary
because `NilClass` has methods like `respond_to?` and `is_a?`.

The `InferNonNilReceiver` option specifies whether to look into previous code
paths to infer if the receiver can't be nil. This check is unsafe because the receiver
can be redefined between the safe navigation call and previous regular method call.
It does the inference only in the current scope, e.g. within the same method definition etc.

The `AdditionalNilMethods` option specifies additional custom methods which are
defined on `NilClass`. When `InferNonNilReceiver` is set, they are used to determine
whether the receiver can be nil.

# Examples

```ruby
# bad
CamelCaseConst&.do_something

# good
CamelCaseConst.do_something

# bad
foo.to_s&.strip
foo.to_i&.zero?
foo.to_f&.zero?
foo.to_a&.size
foo.to_h&.size

# good
foo.to_s.strip
foo.to_i.zero?
foo.to_f.zero?
foo.to_a.size
foo.to_h.size

# bad
do_something if attrs&.respond_to?(:[])

# good
do_something if attrs.respond_to?(:[])

# bad
while node&.is_a?(BeginNode)
  node = node.parent
end

# good
while node.is_a?(BeginNode)
  node = node.parent
end

# good - without `&.` this will always return `true`
foo&.respond_to?(:to_a)

# bad - for `nil`s conversion methods return default values for the type
foo&.to_h || {}
foo&.to_h { |k, v| [k, v] } || {}
foo&.to_a || []
foo&.to_i || 0
foo&.to_f || 0.0
foo&.to_s || ''

# good
foo.to_h
foo.to_h { |k, v| [k, v] }
foo.to_a
foo.to_i
foo.to_f
foo.to_s

# bad
self&.foo

# good
self.foo# bad
do_something if attrs&.nil_safe_method(:[])

# good
do_something if attrs.nil_safe_method(:[])
do_something if attrs&.not_nil_safe_method(:[])# good
foo.bar
foo&.baz# bad
foo.bar
foo&.baz # would raise on previous line if `foo` is nil

# good
foo.bar
foo.baz

# bad
if foo.condition?
  foo&.bar
end

# good
if foo.condition?
  foo.bar
end

# good (different scopes)
def method1
  foo.bar
end

def method2
  foo&.bar
end# good
foo.present?
foo&.bar
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/RedundantSafeNavigation)