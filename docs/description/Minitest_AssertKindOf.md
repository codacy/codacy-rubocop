
Enforces the test to use `assert_kind_of(Class, object)`
over `assert(object.kind_of?(Class))`.

# Examples

```ruby
# bad
assert(object.kind_of?(Class))
assert(object.kind_of?(Class), 'message')

# good
assert_kind_of(Class, object)
assert_kind_of(Class, object, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertKindOf)