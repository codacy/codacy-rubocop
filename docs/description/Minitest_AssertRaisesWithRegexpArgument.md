
Checks for `assert_raises` with arguments of regular expression literals.
Arguments should be exception classes.
Optionally the last argument can be a custom message string to help explain failures.
Either way, it's not the argument that `exception.message` is compared to.
The raised exception is returned and can be used
to match against a regular expression.

# Examples

```ruby

# bad
assert_raises FooError, /some message/ do
  obj.occur_error
end

# good
exception = assert_raises FooError do
  obj.occur_error
end
assert_match(/some message/, exception.message)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertRaisesWithRegexpArgument)