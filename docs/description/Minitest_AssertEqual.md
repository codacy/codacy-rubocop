
Enforces the use of `assert_equal(expected, actual)`
over `assert(expected == actual)`.

# Examples

```ruby
# bad
assert("rubocop-minitest" == actual)

# good
assert_equal("rubocop-minitest", actual)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertEqual)