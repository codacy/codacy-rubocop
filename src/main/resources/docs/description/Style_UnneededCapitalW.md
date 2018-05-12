
This cop checks for usage of the %W() syntax when %w() would do.

# Examples

```ruby
# bad
%W(cat dog pig)
%W[door wall floor]

# good
%w/swim run bike/
%w[shirt pants shoes]
%W(apple #{fruit} grape)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/UnneededCapitalW)