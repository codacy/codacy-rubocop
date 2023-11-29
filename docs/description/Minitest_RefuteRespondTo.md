
Enforces the test to use `refute_respond_to(object, :do_something)`
over `refute(object.respond_to?(:do_something))`.

# Examples

```ruby
# bad
refute(object.respond_to?(:do_something))
refute(object.respond_to?(:do_something), 'message')
refute(respond_to?(:do_something))

# good
refute_respond_to(object, :do_something)
refute_respond_to(object, :do_something, 'message')
refute_respond_to(self, :do_something)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RefuteRespondTo)