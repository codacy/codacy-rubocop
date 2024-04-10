
Checks for cases when you could use a block
accepting version of a method that does automatic
resource cleanup.

# Examples

```ruby

# bad
f = File.open('file')

# good
File.open('file') do |f|
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/AutoResourceCleanup)