
Checks the indentation of comments.

# Examples

```ruby
# bad
  # comment here
def method_name
end

  # comment here
a = 'hello'

# yet another comment
  if true
    true
  end

# good
# comment here
def method_name
end

# comment here
a = 'hello'

# yet another comment
if true
  true
end# bad
a = 1 # A really long comment
      # spanning two lines.

# good
# A really long comment spanning one line.
a = 1# good
a = 1 # A really long comment
      # spanning two lines.
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/CommentIndentation)