
This cop checks for consistent uses of `request.referer` or
`request.referrer`, depending on the cop's configuration.

# Examples

```ruby
# bad
request.referrer

# good
request.referer# bad
request.referer

# good
request.referrer
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RequestReferer)