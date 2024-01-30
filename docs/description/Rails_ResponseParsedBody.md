
Prefer `response.parsed_body` to custom parsing logic for `response.body`.

# Examples

```ruby
# bad
JSON.parse(response.body)

# bad
Nokogiri::HTML.parse(response.body)

# bad
Nokogiri::HTML5.parse(response.body)

# good
response.parsed_body
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ResponseParsedBody)