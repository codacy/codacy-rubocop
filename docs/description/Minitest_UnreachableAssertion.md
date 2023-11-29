
Checks for `assert_raises` has an assertion method at
the bottom of block because the assertion will be never reached.

# Examples

```ruby

# bad
assert_raises FooError do
  obj.occur_error
  assert_equal('foo', obj.bar) # Never asserted.
end

# good
assert_raises FooError do
  obj.occur_error
end
assert_equal('foo', obj.bar)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/UnreachableAssertion)