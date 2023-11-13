
Checks for usage of `Rails.env.development? || Rails.env.test?` which
can be replaced with `Rails.env.local?`, introduced in Rails 7.1.

# Examples

```ruby

# bad
Rails.env.development? || Rails.env.test?

# good
Rails.env.local?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/EnvLocal)