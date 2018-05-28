
Checks that node types are checked using the predicate helpers.

# Examples

```ruby

# bad
node.type == :send

# good
node.send_type?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/InternalAffairs/NodeTypePredicate)