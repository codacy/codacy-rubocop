
Enforces use of symbolic or numeric value to describe HTTP status.

# Examples

```ruby
# bad
it { is_expected.to have_http_status 200 }
it { is_expected.to have_http_status 404 }

# good
it { is_expected.to have_http_status :ok }
it { is_expected.to have_http_status :not_found }
it { is_expected.to have_http_status :success }
it { is_expected.to have_http_status :error }# bad
it { is_expected.to have_http_status :ok }
it { is_expected.to have_http_status :not_found }

# good
it { is_expected.to have_http_status 200 }
it { is_expected.to have_http_status 404 }
it { is_expected.to have_http_status :success }
it { is_expected.to have_http_status :error }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Rails/HttpStatus)