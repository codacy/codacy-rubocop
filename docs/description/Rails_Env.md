
Checks for usage of `Rails.env` which can be replaced with Feature Flags

# Examples

```ruby

# bad
Rails.env.production? || Rails.env.local?

# good
if FeatureFlag.enabled?(:new_feature)
  # new feature code
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/Env)