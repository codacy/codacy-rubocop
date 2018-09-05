
This cop checks for pipes for empty block parameters. Pipes for empty
block parameters do not cause syntax errors, but they are redundant.

# Examples

```ruby
# bad
a do ||
  do_something
end

# bad
a { || do_something }

# good
a do
end

# good
a { do_something }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EmptyBlockParameter)