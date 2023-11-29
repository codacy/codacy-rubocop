
Detects useless assertions (assertions that either always pass or always fail).

# Examples

```ruby
# bad
assert true
assert_equal @foo, @foo
assert_nil [foo, bar]

# good
assert something
assert_equal foo, bar
assert_nil foo
assert false, "My message"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/UselessAssertion)