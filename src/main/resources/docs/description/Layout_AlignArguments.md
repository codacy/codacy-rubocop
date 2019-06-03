
Here we check if the arguments on a multi-line method
definition are aligned.

# Examples

```ruby
# good

foo :bar,
    :baz

foo(
  :bar,
  :baz
)

# bad

foo :bar,
  :baz

foo(
  :bar,
    :baz
)# good

foo :bar,
  :baz

# bad

foo :bar,
    :baz
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/AlignArguments)