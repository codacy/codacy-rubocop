
Enforces the test to use `assert_predicate`
instead of using `assert(obj.a_predicate_method?)`.

# Examples

```ruby
# bad
assert(obj.one?)
assert(obj.one?, 'message')

# good
assert_predicate(obj, :one?)
assert_predicate(obj, :one?, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertPredicate)