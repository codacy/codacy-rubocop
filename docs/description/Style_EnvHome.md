
Checks for consistent usage of `ENV['HOME']`. If `nil` is used as
the second argument of `ENV.fetch`, it is treated as a bad case like `ENV[]`.

# Examples

```ruby

# bad
ENV['HOME']
ENV.fetch('HOME', nil)

# good
Dir.home

# good
ENV.fetch('HOME', default)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EnvHome)