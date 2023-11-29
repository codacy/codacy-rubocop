
Enforces to use `refute_empty` instead of using `refute(object.empty?)`.

# Examples

```ruby
# bad
refute(object.empty?)
refute(object.empty?, 'message')

# good
refute_empty(object)
refute_empty(object, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RefuteEmpty)