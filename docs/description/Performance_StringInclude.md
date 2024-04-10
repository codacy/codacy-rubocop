
Identifies unnecessary use of a regex where `String#include?` would suffice.

# Examples

```ruby
# bad
str.match?(/ab/)
/ab/.match?(str)
str =~ /ab/
/ab/ =~ str
str.match(/ab/)
/ab/.match(str)

# good
str.include?('ab')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/StringInclude)