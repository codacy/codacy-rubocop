
This cop identifies places where `lstrip.rstrip` can be replaced by
`strip`.

# Examples

```ruby
# bad
'abc'.lstrip.rstrip
'abc'.rstrip.lstrip

# good
'abc'.strip
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/LstripRstrip)