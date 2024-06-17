
When using an decorated string to support I18N, any strings inside the decoration should not contain
the '#{}' interpolation string as this makes it hard to translate the strings.

Check GetText.supported_decorators for a list of decorators that can be used.

# Examples

```ruby

# bad

_("result is #{this_is_the_result}")
n_("a string" + "a string with a #{float_value}")
# good

_("result is %{detail}" % {detail: message})
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/I18n/GetText/DecorateStringFormattingUsingInterpolation)