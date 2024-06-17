
When using an decorated string to support I18N, any strings inside the decoration should not contain
the '#{}' interpolation string as this makes it hard to translate the strings.

# Examples

```ruby

# bad

t("status.#{status_string}")
t("status." + "accepted")
# good

t("status.accepted")
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/I18n/RailsI18n/DecorateStringFormattingUsingInterpolation)