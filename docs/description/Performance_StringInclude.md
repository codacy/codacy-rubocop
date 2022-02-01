
This cop identifies unnecessary use of a regex where
`String#include?` would suffice.

# Examples

```ruby
# bad
'abc'.match?(/ab/)
/ab/.match?('abc')
'abc' =~ /ab/
/ab/ =~ 'abc'
'abc'.match(/ab/)
/ab/.match('abc')

# good
'abc'.include?('ab')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/StringInclude)