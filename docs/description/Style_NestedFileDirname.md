
This cop checks for nested `File.dirname`.
It replaces nested `File.dirname` with the level argument introduced in Ruby 3.1.

# Examples

```ruby

# bad
File.dirname(File.dirname(path))

# good
File.dirname(path, 2)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NestedFileDirname)