
This cop checks for comments put on the same line as some keywords.
These keywords are: `begin`, `class`, `def`, `end`, `module`.

Note that some comments (such as `:nodoc:` and `rubocop:disable`) are
allowed.

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