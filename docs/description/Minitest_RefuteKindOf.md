
Enforces the use of `refute_kind_of(Class, object)`
over `refute(object.kind_of?(Class))`.

# Examples

```ruby
# bad
refute(object.kind_of?(Class))
refute(object.kind_of?(Class), 'message')

# bad
# `is_a?` is an alias for `kind_of?`
refute(object.is_of?(Class))
refute(object.is_of?(Class), 'message')

# good
refute_kind_of(Class, object)
refute_kind_of(Class, object, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RefuteKindOf)