
This cop identifies unnecessary use of a regex where
`String#include?` would suffice.

This cop's offenses are not safe to auto-correct if a receiver is nil.

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