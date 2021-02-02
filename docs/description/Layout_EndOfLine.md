
This cop checks for Windows-style line endings in the source code.

# Examples

```ruby
# The `native` style means that CR+LF (Carriage Return + Line Feed) is
# enforced on Windows, and LF is enforced on other platforms.

# bad
puts 'Hello' # Return character is LF on Windows.
puts 'Hello' # Return character is CR+LF on other than Windows.

# good
puts 'Hello' # Return character is CR+LF on Windows.
puts 'Hello' # Return character is LF on other than Windows.# The `lf` style means that LF (Line Feed) is enforced on
# all platforms.

# bad
puts 'Hello' # Return character is CR+LF on all platfoms.

# good
puts 'Hello' # Return character is LF on all platfoms.# The `crlf` style means that CR+LF (Carriage Return + Line Feed) is
# enforced on all platforms.

# bad
puts 'Hello' # Return character is LF on all platfoms.

# good
puts 'Hello' # Return character is CR+LF on all platfoms.
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EndOfLine)