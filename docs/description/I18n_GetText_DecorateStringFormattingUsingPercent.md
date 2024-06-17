
When using a decorated string to support I18N, any strings inside the decoration should not contain sprintf
style formatting as this makes it hard to translate the string. This cop checks the decorators listed in
GetText.supported_decorators and checks for each of the formats in SUPPORTED_FORMATS. NOTE: this cop does not
check for all possible sprintf formats.

# Examples

```ruby

# bad

_("result is %s" % ["value"])
n_("a string" + "a string with a %-3.1f" % [size])
N_("a string" + "a string with a %04d" % [size])
# good

_("result is %{detail}" % {detail: message})
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/I18n/GetText/DecorateStringFormattingUsingPercent)