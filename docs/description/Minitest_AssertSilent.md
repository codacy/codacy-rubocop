
Enforces the test to use `assert_silent { ... }`
instead of using `assert_output('', '') { ... }`.

# Examples

```ruby
# bad
assert_output('', '') { puts object.do_something }

# good
assert_silent { puts object.do_something }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertSilent)