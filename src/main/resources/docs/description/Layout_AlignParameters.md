
Here we check if the parameters on a multi-line method call or
definition are aligned.

# Examples

```ruby
# good

foo :bar,
    :baz

# bad

foo :bar,
  :baz# good

foo :bar,
  :baz

# bad

foo :bar,
    :baz
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/AlignParameters)