
Prefer `response.parsed_body` to custom parsing logic for `response.body`.

# Examples

```ruby
# bad
JSON.parse(response.body)
Nokogiri::HTML(response.body)
Nokogiri::HTML4(response.body)
Nokogiri::HTML5(response.body)
Nokogiri::HTML.parse(response.body)
Nokogiri::HTML4.parse(response.body)
Nokogiri::HTML5.parse(response.body)
Nokogiri::HTML::Document.parse(response.body)
Nokogiri::HTML4::Document.parse(response.body)
Nokogiri::HTML5::Document.parse(response.body)

# good
response.parsed_body
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ResponseParsedBody)