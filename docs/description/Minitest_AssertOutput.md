
Checks for opportunities to use `assert_output`.

# Examples

```ruby
# bad
$stdout = StringIO.new
puts object.method
$stdout.rewind
assert_match expected, $stdout.read

# good
assert_output(expected) { puts object.method }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/AssertOutput)