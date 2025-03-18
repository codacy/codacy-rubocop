
Check that the arguments on a multi-line method call are aligned.

# Examples

```ruby
# good

foo :bar,
    :baz,
    key: value

foo(
  :bar,
  :baz,
  key: value
)

# bad

foo :bar,
  :baz,
  key: value

foo(
  :bar,
    :baz,
    key: value
)# good

foo :bar,
  :baz,
  key: value

# bad

foo :bar,
    :baz,
    key: value
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/ArgumentAlignment)