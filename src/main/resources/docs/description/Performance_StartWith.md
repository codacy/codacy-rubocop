
This cop identifies unnecessary use of a regex where
`String#start_with?` would suffice.

# Examples

```ruby
# bad
'abc'.match?(/\Aab/)
'abc' =~ /\Aab/
'abc'.match(/\Aab/)

# good
'abc'.start_with?('ab')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/StartWith)