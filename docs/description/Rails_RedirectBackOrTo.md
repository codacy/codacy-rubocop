
Checks for uses of `redirect_back(fallback_location: ...)` and
suggests using `redirect_back_or_to(...)` instead.

`redirect_back(fallback_location: ...)` was soft deprecated in Rails 7.0 and
`redirect_back_or_to` was introduced as a replacement.

# Examples

```ruby
# bad
redirect_back(fallback_location: root_path)

# good
redirect_back_or_to(root_path)

# bad
redirect_back(fallback_location: root_path, allow_other_host: false)

# good
redirect_back_or_to(root_path, allow_other_host: false)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RedirectBackOrTo)