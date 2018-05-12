
This cop checks the . position in multi-line method calls.

# Examples

```ruby
# bad
something.
  mehod

# good
something
  .method# bad
something
  .method

# good
something.
  mehod
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/DotPosition)