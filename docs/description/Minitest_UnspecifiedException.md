
Checks for a specified error in `assert_raises`.

# Examples

```ruby
# bad
assert_raises { raise FooException }
assert_raises('This should have raised') { raise FooException }

# good
assert_raises(FooException) { raise FooException }
assert_raises(FooException, 'This should have raised') { raise FooException }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/UnspecifiedException)