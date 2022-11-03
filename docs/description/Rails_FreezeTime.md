
Identifies usages of `travel_to` with an argument of the current time and
change them to use `freeze_time` instead.

# Examples

```ruby
# bad
travel_to(Time.now)
travel_to(Time.new)
travel_to(DateTime.now)
travel_to(Time.current)
travel_to(Time.zone.now)
travel_to(Time.now.in_time_zone)
travel_to(Time.current.to_time)

# good
freeze_time
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/FreezeTime)