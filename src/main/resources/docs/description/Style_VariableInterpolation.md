
This cop checks for variable interpolation (like "#@ivar").

# Examples

```ruby
# bad
"His name is #$name"
/check #$pattern/
"Let's go to the #@store"

# good
"His name is #{$name}"
/check #{$pattern}/
"Let's go to the #{@store}"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/VariableInterpolation)