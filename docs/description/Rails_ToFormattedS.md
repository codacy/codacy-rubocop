
Checks for consistent uses of `to_fs` or `to_formatted_s`,
depending on the cop's configuration.

# Examples

```ruby

# bad
time.to_formatted_s(:db)

# good
time.to_fs(:db)
# bad
time.to_fs(:db)

# good
time.to_formatted_s(:db)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ToFormattedS)