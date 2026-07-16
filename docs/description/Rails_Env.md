
Checks for usage of `Rails.env` which can be replaced with Feature Flags

The cop does not flag `Rails.env.local?`, the built-in alias for
"development or test" introduced in Rails 7.1. Unlike per-environment
predicates such as `development?` or `production?`, `local?` expresses
the intent of guarding code that must only ever run in development or
test (sanity checks, devtools, seed data) rather than gating an
environment rollout, so a Feature Flag is not a suitable replacement.

# Examples

```ruby

# bad
Rails.env.production? || Rails.env.development?

# good
if FeatureFlag.enabled?(:new_feature)
  # new feature code
end

# good
raise 'This should never run in production' unless Rails.env.local?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/Env)