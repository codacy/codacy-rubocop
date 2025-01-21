
Looks for strings that appear to be sentences but are not decorated.
Sentences are determined by the STRING_REGEXP. (Upper case character, at least one space,
and sentence punctuation at the end)

# Examples

```ruby

# bad

"Result is bad."
# good

_("Result is good.")
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/I18n/GetText/DecorateString)