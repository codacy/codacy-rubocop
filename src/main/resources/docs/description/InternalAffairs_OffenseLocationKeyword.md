
Checks for potential uses of the location keywords which can be used as
shortcut arguments to `#add_offense`.

# Examples

```ruby

# bad
add_offense(node, location: node.loc.selector)

# good
add_offense(node, location: :selector)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/InternalAffairs/OffenseLocationKeyword)