
Checks that block braces have or don't have a space before the opening
brace depending on configuration.

# Examples

```ruby
# bad
foo.map{ |a|
  a.bar.to_s
}

# good
foo.map { |a|
  a.bar.to_s
}# bad
foo.map { |a|
  a.bar.to_s
}

# good
foo.map{ |a|
  a.bar.to_s
}
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceBeforeBlockBraces)