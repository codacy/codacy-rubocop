
Looks for direct access to environment variables through the
`ENV` variable within the application code. This can lead to runtime
errors due to misconfiguration that could have been discovered at boot
time if the environment variables were loaded as part of initialization
and copied into the application's configuration or secrets. The cop can
be configured to allow either reads or writes if required.

# Examples

```ruby
# good
Rails.application.config.foo
Rails.application.config.x.foo.bar
Rails.application.secrets.foo
Rails.application.config.foo = "bar"# bad
ENV["FOO"]
ENV.fetch("FOO")# good
ENV["FOO"]
ENV.fetch("FOO")# bad
ENV["FOO"] = "bar"# good
ENV["FOO"] = "bar"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/EnvironmentVariableAccess)