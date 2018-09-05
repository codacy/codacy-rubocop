
This cop checks that environments called with `Rails.env` predicates
exist.

# Examples

```ruby
# bad
Rails.env.proudction?

# good
Rails.env.production?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/UnknownEnv)