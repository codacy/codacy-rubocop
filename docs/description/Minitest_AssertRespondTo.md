
Enforces the use of `assert_respond_to(object, :do_something)`
over `assert(object.respond_to?(:do_something))`.

# Examples

```ruby
# bad
assert(object.respond_to?(:do_something))
assert(object.respond_to?(:do_something), 'message')
assert(respond_to?(:do_something))

# good
assert_respond_to(object, :do_something)
assert_respond_to(object, :do_something, 'message')
assert_respond_to(self, :do_something)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertRespondTo)