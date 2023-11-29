
Enforces empty line before assertion methods because it separates assertion phase.

# Examples

```ruby

# bad
do_something
assert_equal(expected, actual)

# good
do_something

assert_equal(expected, actual)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/EmptyLineBeforeAssertionMethods)