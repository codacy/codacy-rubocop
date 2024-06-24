
Checks that tests use `have_http_status` instead of equality matchers.

# Examples

```ruby
# bad
expect(response.status).to be(200)
expect(last_response.code).to eq("200")

# good
expect(response).to have_http_status(200)
expect(last_response).to have_http_status(200)# bad
expect(foo_response.status).to be(200)

# good
expect(foo_response).to have_http_status(200)

# also good
expect(response).to have_http_status(200)
expect(last_response).to have_http_status(200)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpecRails/HaveHttpStatus)