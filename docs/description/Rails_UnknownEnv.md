
Checks that environments called with `Rails.env` predicates
exist.
By default the cop allows three environments which Rails ships with:
`development`, `test`, and `production`.
More can be added to the `Environments` config parameter.

# Examples

```ruby
# bad
Rails.env.proudction?
Rails.env == 'proudction'
Rails.env != 'proudction'

# good
Rails.env.production?
Rails.env == 'production'
Rails.env != 'production'

# bad
case Rails.env
when 'proudction'
  do_something
end

# good
case Rails.env
when 'production'
  do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/UnknownEnv)