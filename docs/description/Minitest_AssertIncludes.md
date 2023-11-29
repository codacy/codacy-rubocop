
Enforces the test to use `assert_includes`
instead of using `assert(collection.include?(object))`.

# Examples

```ruby
# bad
assert(collection.include?(object))
assert(collection.include?(object), 'message')

# good
assert_includes(collection, object)
assert_includes(collection, object, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertIncludes)