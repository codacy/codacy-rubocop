
Use `assert_not` methods instead of `refute` methods.

# Examples

```ruby
# bad
refute false
refute_empty [1, 2, 3]
refute_equal true, false

# good
assert_not false
assert_not_empty [1, 2, 3]
assert_not_equal true, false
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RefuteMethods)