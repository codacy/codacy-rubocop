
Checks for methods of button or link clicks.

This cop is deprecated.
We plan to remove this in the next major version update to 3.0.

The migration target is `Capybara/AmbiguousClick`.
It is only migration target when `EnforcedStyle: strict`.
If you are using this cop, please plan for migration.
There is no migration target when `EnforcedStyle: link_or_button`.

By default, prefer to use `click_link_or_button` or `click_on`.
These methods offer a weaker coupling between the test and HTML,
allowing for a more faithful reflection of how the user behaves.

You can set `EnforcedStyle: strict` to prefer the use of
`click_link` and `click_button`, but this is a deprecated setting.

# Examples

```ruby
# bad
click_link('foo')
click_button('foo')

# good
click_link_or_button('foo')
click_on('foo')# bad
click_link_or_button('foo')
click_on('foo')

# good
click_link('foo')
click_button('foo')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/ClickLinkOrButtonStyle)