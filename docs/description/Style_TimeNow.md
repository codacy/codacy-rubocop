
Checks for `Time.new` without arguments, which is an implicit way
to retrieve the current system time. Prefer the more explicit `Time.now`.

# Examples

```ruby
# bad
Time.new

# good
Time.now

# good - `Time.new` with arguments constructs a specific time
Time.new(2026, 8, 19)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TimeNow)