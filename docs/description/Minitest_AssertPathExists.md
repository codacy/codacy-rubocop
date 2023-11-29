
Enforces the test to use `assert_path_exists` instead of using `assert(File.exist?(path))`.

# Examples

```ruby
# bad
assert(File.exist?(path))
assert(File.exist?(path), 'message')

# good
assert_path_exists(path)
assert_path_exists(path, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertPathExists)