
Enforces consistency by using the current HTTP status names.

# Examples

```ruby

# bad
it { is_expected.to have_http_status :unprocessable_entity }

# good
it { is_expected.to have_http_status :unprocessable_content }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpecRails/HttpStatusNameConsistency)