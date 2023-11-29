
Enforces the test to use `refute_includes`
instead of using `refute(collection.include?(object))`.

# Examples

```ruby
# bad
refute(collection.include?(object))
refute(collection.include?(object), 'message')

# good
refute_includes(collection, object)
refute_includes(collection, object, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RefuteIncludes)