
Identifies places where `split` argument can be replaced from
a deterministic regexp to a string.

# Examples

```ruby
# bad
'a,b,c'.split(/,/)

# good
'a,b,c'.split(',')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/RedundantSplitRegexpArgument)