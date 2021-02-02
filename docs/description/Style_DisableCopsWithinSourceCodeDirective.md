
Detects comments to enable/disable RuboCop.
This is useful if want to make sure that every RuboCop error gets fixed
and not quickly disabled with a comment.

Specific cops can be allowed with the `AllowedCops` configuration. Note that
if this configuration is set, `rubocop:disable all` is still disallowed.

# Examples

```ruby
# bad
# rubocop:disable Metrics/AbcSize
def foo
end
# rubocop:enable Metrics/AbcSize

# good
def foo
end# good
# rubocop:disable Metrics/AbcSize
def foo
end
# rubocop:enable Metrics/AbcSize
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/DisableCopsWithinSourceCodeDirective)