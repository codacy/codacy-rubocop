
Makes the Sorbet typed sigil mandatory in all files.

Options:

* `SuggestedStrictness`: Sorbet strictness level suggested in offense messages (default: 'false')
* `MinimumStrictness`: If set, make offense if the strictness level in the file is below this one

If a `SuggestedStrictness` level is specified, it will be used in autocorrect.
If a `MinimumStrictness` level is specified, it will be used in offense messages and autocorrect.

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/HasSigil)