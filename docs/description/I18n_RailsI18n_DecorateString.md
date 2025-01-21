
Looks for strings that appear to be sentences but are not decorated.
Sentences are determined by the SENTENCE_REGEXP. (Upper case character, at least one space,
and sentence punctuation at the end)

There are several options for configuration.

# Examples

```ruby

# bad

"Result is bad."
# good

t("result_is_good")
I18n.t("result_is_good")# OK

raise "Some string sentence"# bad

"Result is bad."

# good

t("result_is_good")
I18n.t("result_is_good")# bad

"Result is bad"   # Contains a capital to start
"result is bad."  # Ends in punctuation

# good

t("result_is_good")
I18n.t("result_is_good")# bad

"result is bad"   # A series of words

# good

t("result_is_good")
I18n.t("result_is_good")
# bad

"only-this-text"

# good

"Any other string is fine now"
t("only_this_text")
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/I18n/RailsI18n/DecorateString)