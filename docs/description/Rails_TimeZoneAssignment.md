
This cop checks for the use of `Time.zone=` method.

The `zone` attribute persists for the rest of the Ruby runtime, potentially causing
unexpected behaviour at a later time.
Using `Time.use_zone` ensures the code passed in block is the only place Time.zone is affected.
It eliminates the possibility of a `zone` sticking around longer than intended.

# Examples

```ruby
# bad
Time.zone = 'EST'

# good
Time.use_zone('EST') do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/TimeZoneAssignment)