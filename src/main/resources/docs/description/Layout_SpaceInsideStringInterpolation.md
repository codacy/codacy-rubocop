
This cop checks for whitespace within string interpolations.

# Examples

```ruby
# bad
   var = "This is the #{ space } example"

# good
   var = "This is the #{no_space} example"# bad
   var = "This is the #{no_space} example"

# good
   var = "This is the #{ space } example"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceInsideStringInterpolation)