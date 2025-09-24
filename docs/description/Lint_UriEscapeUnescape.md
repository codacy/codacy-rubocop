
Identifies places where `URI.escape` can be replaced by
`CGI.escape`, `URI.encode_www_form`, or `URI.encode_www_form_component`
depending on your specific use case.
Also this cop identifies places where `URI.unescape` can be replaced by
`CGI.unescape`, `URI.decode_www_form`,
or `URI.decode_www_form_component` depending on your specific use case.

# Examples

```ruby
# bad
URI.escape('http://example.com')
URI.encode('http://example.com')

# good
CGI.escape('http://example.com')
URI.encode_uri_component(uri) # Since Ruby 3.1
URI.encode_www_form([['example', 'param'], ['lang', 'en']])
URI.encode_www_form(page: 10, locale: 'en')
URI.encode_www_form_component('http://example.com')

# bad
URI.unescape(enc_uri)
URI.decode(enc_uri)

# good
CGI.unescape(enc_uri)
URI.decode_uri_component(uri) # Since Ruby 3.1
URI.decode_www_form(enc_uri)
URI.decode_www_form_component(enc_uri)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UriEscapeUnescape)