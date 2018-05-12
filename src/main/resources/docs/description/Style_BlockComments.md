
This cop looks for uses of block comments (=begin...=end).

# Examples

```ruby
# bad
=begin
Multiple lines
of comments...
=end

# good
# Multiple lines
# of comments...
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/BlockComments)