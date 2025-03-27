
Checks for comments put on the same line as some keywords.
These keywords are: `class`, `module`, `def`, `begin`, `end`.

Note that some comments
(`:nodoc:`, `:yields:`, `rubocop:disable` and `rubocop:todo`),
RBS::Inline annotation, and Steep annotation (`steep:ignore`) are allowed.

Autocorrection removes comments from `end` keyword and keeps comments
for `class`, `module`, `def` and `begin` above the keyword.

# Examples

```ruby
# bad
if condition
  statement
end # end if

# bad
class X # comment
  statement
end

# bad
def x; end # comment

# good
if condition
  statement
end

# good
class X # :nodoc:
  y
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CommentedKeyword)