
This cop looks for trailing whitespace in the source code.

# Examples

```ruby
# The line in this example contains spaces after the 0.
# bad
x = 0

# The line in this example ends directly after the 0.
# good
x = 0# The line in this example contains spaces after the 0.
# bad
code = <<~RUBY
  x = 0
RUBY# The line in this example contains spaces after the 0.
# good
code = <<~RUBY
  x = 0
RUBY
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/TrailingWhitespace)