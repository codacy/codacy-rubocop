
This cop checks for hardcoded IP addresses, which can make code
brittle. IP addresses are likely to need to be changed when code
is deployed to a different server or environment, which may break
a deployment if forgotten. Prefer setting IP addresses in ENV or
other configuration.

# Examples

```ruby

# bad
ip_address = '127.59.241.29'

# good
ip_address = ENV['DEPLOYMENT_IP_ADDRESS']
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/IpAddresses)