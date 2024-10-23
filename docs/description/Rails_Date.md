
Checks for the correct use of Date methods,
such as Date.today, Date.current etc.

Using `Date.today` is dangerous, because it doesn't know anything about
Rails time zone. You must use `Time.zone.today` instead.

The cop also reports warnings when you are using `to_time` method,
because it doesn't know about Rails time zone either.

Two styles are supported for this cop. When `EnforcedStyle` is `strict`
then the Date methods `today`, `current`, `yesterday`, and `tomorrow`
are prohibited and the usage of both `to_time`
and `to_time_in_current_zone` are reported as warning.

When `EnforcedStyle` is `flexible` then only `Date.today` is prohibited.

And you can set a warning for `to_time` with `AllowToTime: false`.
`AllowToTime` is `true` by default to prevent false positive on `DateTime` object.

# Examples

```ruby
# bad
Date.today

# good
Time.zone.today
Time.zone.today - 1.day
Date.current
Date.yesterday
date.in_time_zone# bad
Date.current
Date.yesterday
Date.today

# good
Time.zone.today
Time.zone.today - 1.day# good
date.to_time# bad
date.to_time
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/Date)