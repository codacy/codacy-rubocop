
This cop identifies unnecessary use of a regex where `String#end_with?`
would suffice.

# Examples

```ruby
# bad
'abc'.match?(/bc\Z/)
'abc' =~ /bc\Z/
'abc'.match(/bc\Z/)

# good
'abc'.end_with?('bc')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/EndWith)