
This cop checks for unnecessary leading blank lines at the beginning
of a file.

# Examples

```ruby

# bad
# (start of file)

class Foo
end

# bad
# (start of file)

# a comment

# good
# (start of file)
class Foo
end

# good
# (start of file)
# a comment
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/LeadingBlankLines)