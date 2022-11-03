
Checks that the backslash of a line continuation is separated from
preceding text by exactly one space (default) or zero spaces.

# Examples

```ruby
# bad
'a'\
'b'  \
'c'

# good
'a' \
'b' \
'c'# bad
'a' \
'b'  \
'c'

# good
'a'\
'b'\
'c'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/LineContinuationSpacing)