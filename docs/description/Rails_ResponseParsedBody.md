
Prefer `response.parsed_body` to `JSON.parse(response.body)`.

# Examples

```ruby
# bad
JSON.parse(response.body)

# good
response.parsed_body
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ResponseParsedBody)