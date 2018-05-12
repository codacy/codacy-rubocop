
This cop identifies places where `$stderr.puts` can be replaced by
`warn`. The latter has the advantage of easily being disabled by,
e.g. the -W0 interpreter flag, or setting $VERBOSE to nil.

# Examples

```ruby
# bad
$stderr.puts('hello')

# good
warn('hello')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/StderrPuts)