
This cop identifies places where `URI::Parser.new`
can be replaced by `URI::DEFAULT_PARSER`.

# Examples

```ruby
# bad
URI::Parser.new

# good
URI::DEFAULT_PARSER
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/UriDefaultParser)