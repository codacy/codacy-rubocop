
This cop looks for trailing blank lines and a final newline in the
source code.

# Examples

```ruby
# `final_blank_line` looks for one blank line followed by a new line
# at the end of files.

# bad
class Foo; end
# EOF

# bad
class Foo; end # EOF

# good
class Foo; end

# EOF# `final_newline` looks for one newline at the end of files.

# bad
class Foo; end

# EOF

# bad
class Foo; end # EOF

# good
class Foo; end
# EOF
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/TrailingBlankLines)