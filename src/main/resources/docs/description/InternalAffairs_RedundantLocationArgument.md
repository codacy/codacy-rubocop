
Checks for redundant `location` argument to `#add_offense`. `location`
argument has a default value of `:expression` and this method will
automatically use it.

# Examples

```ruby

# bad
add_offense(node, location: :expression)

# good
add_offense(node)
add_offense(node, location: :selector)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/InternalAffairs/RedundantLocationArgument)