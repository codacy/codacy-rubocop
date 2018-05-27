
Checks that node destructuring is done either using the node
extensions or using a splat.

# Examples

```ruby

# bad
receiver, method_name, arguments = send_node.children

# good
receiver, method_name, arguments = *send_node
# bad
_receiver, method_name, _arguments = send_node.children

# good
method_name = send_node.method_name
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/InternalAffairs/NodeDestructuring)