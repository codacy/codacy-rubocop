
Enforces use of symbolic or numeric value to describe HTTP status.

This cop inspects only `have_http_status` calls.
So, this cop does not check if a method starting with `be_*` is used
when setting for `EnforcedStyle: symbolic` or
`EnforcedStyle: numeric`.

# Examples

```ruby
# bad
it { is_expected.to have_http_status 200 }
it { is_expected.to have_http_status 404 }
it { is_expected.to have_http_status "403" }

# good
it { is_expected.to have_http_status :ok }
it { is_expected.to have_http_status :not_found }
it { is_expected.to have_http_status :forbidden }
it { is_expected.to have_http_status :success }
it { is_expected.to have_http_status :error }# bad
it { is_expected.to have_http_status :ok }
it { is_expected.to have_http_status :not_found }
it { is_expected.to have_http_status "forbidden" }

# good
it { is_expected.to have_http_status 200 }
it { is_expected.to have_http_status 404 }
it { is_expected.to have_http_status 403 }
it { is_expected.to have_http_status :success }
it { is_expected.to have_http_status :error }# bad
it { is_expected.to have_http_status :ok }
it { is_expected.to have_http_status :not_found }
it { is_expected.to have_http_status "forbidden" }
it { is_expected.to have_http_status 200 }
it { is_expected.to have_http_status 404 }
it { is_expected.to have_http_status "403" }

# good
it { is_expected.to be_ok }
it { is_expected.to be_not_found }
it { is_expected.to have_http_status :success }
it { is_expected.to have_http_status :error }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpecRails/HttpStatus)