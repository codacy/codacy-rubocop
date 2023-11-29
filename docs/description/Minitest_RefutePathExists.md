
Enforces the test to use `refute_path_exists` instead of using `refute(File.exist?(path))`.

# Examples

```ruby
# bad
refute(File.exist?(path))
refute(File.exist?(path), 'message')

# good
refute_path_exists(path)
refute_path_exists(path, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RefutePathExists)