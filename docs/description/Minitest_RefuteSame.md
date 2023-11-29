
Enforces the use of `refute_same(expected, object)`
over `refute(expected.equal?(actual))`.

NOTE: Use `refute_same` only when there is a need to compare by identity.
      Otherwise, use `refute_equal`.

# Examples

```ruby
# bad
refute(expected.equal?(actual))

# good
refute_same(expected, actual)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RefuteSame)