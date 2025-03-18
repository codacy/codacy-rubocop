
Checks that every Ruby file contains a valid Sorbet sigil.
Adapted from: https://gist.github.com/clarkdave/85aca4e16f33fd52aceb6a0a29936e52

Options:

* `RequireSigilOnAllFiles`: make offense if the Sorbet typed is not found in the file (default: false)
* `SuggestedStrictness`: Sorbet strictness level suggested in offense messages (default: 'false')
* `MinimumStrictness`: If set, make offense if the strictness level in the file is below this one
* `ExactStrictness`: If set, make offense if the strictness level in the file is different than this one

If an `ExactStrictness` level is specified, it will be used in offense messages and autocorrect.
If a `SuggestedStrictness` level is specified, it will be used in autocorrect.
Otherwise, if a `MinimumStrictness` level is specified, it will be used in offense messages and autocorrect.

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ValidSigil)