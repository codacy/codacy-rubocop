
Checks for redundant message arguments to `#add_offense`. This method
will automatically use `#message` or `MSG` (in that order of priority)
if they are defined.

# Examples

```ruby

# bad
add_offense(node, message: MSG)
add_offense(node, message: message)
add_offense(node, message: message(node))

# good
add_offense(node)
add_offense(node, message: CUSTOM_MSG)
add_offense(node, message: message(other_node))
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/InternalAffairs/RedundantMessageArgument)