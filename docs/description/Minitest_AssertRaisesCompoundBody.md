
Enforces the block body of `assert_raises { ... }` to be reduced to only the raising code.

# Examples

```ruby
# bad
assert_raises(MyError) do
  foo
  bar
end

# good
assert_raises(MyError) do
  foo
end

# good
assert_raises(MyError) do
  foo do
    bar
    baz
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertRaisesCompoundBody)