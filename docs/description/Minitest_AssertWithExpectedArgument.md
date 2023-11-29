
Tries to detect when a user accidentally used
`assert` when they meant to use `assert_equal`.

NOTE: The second argument to the `assert` method named `message` and `msg` is allowed.
      Because their names are inferred as message arguments.

# Examples

```ruby
# bad
assert(3, my_list.length)
assert(expected, actual)

# good
assert_equal(3, my_list.length)
assert_equal(expected, actual)
assert(foo, 'message')
assert(foo, message)
assert(foo, msg)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertWithExpectedArgument)