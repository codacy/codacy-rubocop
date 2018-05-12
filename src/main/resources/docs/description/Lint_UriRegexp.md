
This cop identifies places where `URI.regexp` is obsolete and should
not be used. Instead, use `URI::DEFAULT_PARSER.make_regexp`.

# Examples

```ruby
# bad
URI.regexp('http://example.com')

# good
URI::DEFAULT_PARSER.make_regexp('http://example.com')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UriRegexp)