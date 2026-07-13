
Checks for uses of the case equality operator (`===`).
The `===` operator has different behavior depending on the
receiver and its use outside of `case`/`when` is confusing.
Prefer more explicit alternatives like `is_a?`, `include?`,
or `match?`.

If `AllowOnConstant` option is enabled, the cop will ignore violations when the receiver of
the case equality operator is a constant.

If `AllowOnSelfClass` option is enabled, the cop will ignore violations when the receiver of
the case equality operator is `self.class`. Note intermediate variables are not accepted.

NOTE: Regexp case equality (`/regexp/ === var`) is allowed because changing it to
`/regexp/.match?(var)` needs to take into account `Regexp.last_match?`, `$~`, `$1`, etc.
This potentially incompatible transformation is handled by `Performance/RegexpMatch` cop.

# Examples

```ruby
# bad
(1..100) === 7

# good
(1..100).include?(7)

# bad
Array === something

# good
something.is_a?(Array)

# good
Array === something
something.is_a?(Array)

# bad
self.class === something

# good
self.class === something
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CaseEquality)