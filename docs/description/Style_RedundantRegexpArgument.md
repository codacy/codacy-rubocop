
Identifies places where argument can be replaced from
a deterministic regexp to a string.

# Examples

```ruby
# bad
'foo'.byteindex(/f/)
'foo'.byterindex(/f/)
'foo'.gsub(/f/, 'x')
'foo'.gsub!(/f/, 'x')
'foo'.partition(/f/)
'foo'.rpartition(/f/)
'foo'.scan(/f/)
'foo'.split(/f/)
'foo'.start_with?(/f/)
'foo'.sub(/f/, 'x')
'foo'.sub!(/f/, 'x')

# good
'foo'.byteindex('f')
'foo'.byterindex('f')
'foo'.gsub('f', 'x')
'foo'.gsub!('f', 'x')
'foo'.partition('f')
'foo'.rpartition('f')
'foo'.scan('f')
'foo'.split('f')
'foo'.start_with?('f')
'foo'.sub('f', 'x')
'foo'.sub!('f', 'x')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantRegexpArgument)