
Enforces the test to use `assert_instance_of(Class, object)`
over `assert(object.instance_of?(Class))`.

# Examples

```ruby
# bad
assert(object.instance_of?(Class))
assert(object.instance_of?(Class), 'message')

# bad
assert_equal(Class, object.class)
assert_equal(Class, object.class, 'message')

# good
assert_instance_of(Class, object)
assert_instance_of(Class, object, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertInstanceOf)