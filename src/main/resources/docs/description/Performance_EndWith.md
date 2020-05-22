
This cop identifies unnecessary use of a regex where `String#end_with?`
would suffice.

# Examples

```ruby
# bad
'abc'.match?(/bc\Z/)
/bc\Z/.match?('abc')
'abc' =~ /bc\Z/
/bc\Z/ =~ 'abc'
'abc'.match(/bc\Z/)
/bc\Z/.match('abc')

'abc'.match?(/bc$/)
/bc$/.match?('abc')
'abc' =~ /bc$/
/bc$/ =~ 'abc'
'abc'.match(/bc$/)
/bc$/.match('abc')

# good
'abc'.end_with?('bc')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/EndWith)