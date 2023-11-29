
Enforces the use of `refute_equal(expected, object)`
over `assert(expected != actual)` or `assert(! expected == actual)`.

# Examples

```ruby
# bad
assert("rubocop-minitest" != actual)
refute("rubocop-minitest" == actual)
assert_operator("rubocop-minitest", :!=, actual)
refute_operator("rubocop-minitest", :==, actual)

# good
refute_equal("rubocop-minitest", actual)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RefuteEqual)