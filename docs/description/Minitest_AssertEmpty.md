
Enforces the test to use `assert_empty` instead of using `assert(object.empty?)`.

# Examples

```ruby
# bad
assert(object.empty?)
assert(object.empty?, 'message')

# good
assert_empty(object)
assert_empty(object, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertEmpty)