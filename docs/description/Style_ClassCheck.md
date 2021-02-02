
This cop enforces consistent use of `Object#is_a?` or `Object#kind_of?`.

# Examples

```ruby
# bad
var.kind_of?(Date)
var.kind_of?(Integer)

# good
var.is_a?(Date)
var.is_a?(Integer)# bad
var.is_a?(Time)
var.is_a?(String)

# good
var.kind_of?(Time)
var.kind_of?(String)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ClassCheck)