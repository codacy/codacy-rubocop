
Disallows using `T.assert_type!` anywhere.

# Examples

```ruby

# bad
T.assert_type!(foo, Integer)

# good
raise unless foo.is_a?(Integer)

# good
assert_kind_of(Integer, foo)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTAssertType)