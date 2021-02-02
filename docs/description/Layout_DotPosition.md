
This cop checks the . position in multi-line method calls.

# Examples

```ruby
# bad
something.
  method

# good
something
  .method# bad
something
  .method

# good
something.
  method
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/DotPosition)