
Checks for disabling the deep munge security control.

Disabling this security setting can leave the application open to unsafe
query generation

See CVE-2012-2660, CVE-2012-2694, and CVE-2013-0155.

# Examples

```ruby

# bad
config.action_dispatch.perform_deep_munge = false
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GitlabSecurity/DeepMunge)