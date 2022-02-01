
This cop checks for the use of Time methods without zone.

Built on top of Ruby on Rails style guide (https://rails.rubystyle.guide#time)
and the article http://danilenko.org/2012/7/6/rails_timezones/

Two styles are supported for this cop. When `EnforcedStyle` is 'strict'
then only use of `Time.zone` is allowed.

When EnforcedStyle is 'flexible' then it's also allowed
to use `Time#in_time_zone`.

# Examples

```ruby
# bad
Time.now
Time.parse('2015-03-02T19:05:37')

# good
Time.current
Time.zone.now
Time.zone.parse('2015-03-02T19:05:37')
Time.zone.parse('2015-03-02T19:05:37Z') # Respect ISO 8601 format with timezone specifier.# `strict` means that `Time` should be used with `zone`.

# bad
Time.at(timestamp).in_time_zone# `flexible` allows usage of `in_time_zone` instead of `zone`.

# good
Time.at(timestamp).in_time_zone
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/TimeZone)