
Enforces the use of `refute_instance_of(Class, object)`
over `refute(object.instance_of?(Class))`.

# Examples

```ruby
# bad
refute(object.instance_of?(Class))
refute(object.instance_of?(Class), 'message')

# bad
refute_equal(Class, object.class)
refute_equal(Class, object.class, 'message')

# good
refute_instance_of(Class, object)
refute_instance_of(Class, object, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RefuteInstanceOf)