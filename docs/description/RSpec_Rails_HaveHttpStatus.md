
Checks that tests use `have_http_status` instead of equality matchers.

# Examples

```ruby
# bad
expect(response.status).to be(200)

# good
expect(response).to have_http_status(200)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Rails/HaveHttpStatus)