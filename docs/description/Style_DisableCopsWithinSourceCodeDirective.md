
Detects comments to enable/disable RuboCop.
This is useful if you want to make sure that every RuboCop error gets fixed
and not quickly disabled with a comment.

Specific cops can be allowed with the `AllowedCops` configuration. Note that
if this configuration is set, `rubocop:disable all` is still disallowed.

`AllowedCops` and `DisallowedCops` accept cop names and department names
alike. Listing a cop does not cover its whole department: a directive
disabling `Metrics` is broader than one disabling `Metrics/AbcSize`.

Alternatively, specific cops can be disallowed with the `DisallowedCops`
configuration. When `DisallowedCops` is set, only directives for the listed
cops (and `all`) will be flagged. This is useful when you want
to protect a small set of critical cops from being disabled rather than
allowlisting all other cops. `AllowedCops` and `DisallowedCops` should not
both be set at the same time; if `DisallowedCops` is set, it takes precedence.

`AllowedDirectives` names directive forms - `disable`, `todo`,
`disable-next`, `todo-next`, `push`, `next` - and exempts them from the
cop entirely. `rubocop:todo` is the usual candidate, since
`--disable-uncorrectable` generates those and they record debt rather
than a decision someone should be asked to justify.

With `AllowWithReason` set to `true`, a disable directive carrying
a `--` trailing justification comment is allowed, so a team can require
every disable to be documented instead of banning them outright. Enable
directives are not checked in this mode, since they end a suppression
rather than start one.

This cop cannot be disabled via directive comments when it is explicitly
enabled with `Enabled: true`. This prevents users from bypassing the cop
with `# rubocop:disable Style/DisableCopsWithinSourceCodeDirective`.

# Examples

```ruby
# bad
# rubocop:disable Metrics/AbcSize
def foo
end
# rubocop:enable Metrics/AbcSize

# good
def foo
end

# good
# rubocop:disable Metrics/AbcSize
def foo
end
# rubocop:enable Metrics/AbcSize

# bad
# rubocop:disable Lint/Void
foo
# rubocop:enable Lint/Void

# good
# rubocop:disable Metrics/AbcSize
foo
# rubocop:enable Metrics/AbcSize

# good - the cop does not look at `todo` directives at all
x = 0 # rubocop:todo Layout/SpaceAroundOperators

# bad
x = 0 # rubocop:disable Layout/SpaceAroundOperators

# good - every cop the directive disables is in an exempt department
# rubocop:disable Metrics/AbcSize
def foo
end
# rubocop:enable Metrics/AbcSize

# bad
x = 0 # rubocop:disable Layout/SpaceAroundOperators

# good
x = 0 # rubocop:disable Layout/SpaceAroundOperators -- would misalign the table
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/DisableCopsWithinSourceCodeDirective)