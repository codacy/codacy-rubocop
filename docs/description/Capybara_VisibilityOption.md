
Checks for boolean values passed to Capybara's `visible` option.

`visible: false` finds both visible and hidden elements, rather than
only hidden elements. Use `:all`, `:hidden` or `:visible` instead.
Only `true` is autocorrected, to `:visible`.

This cop targets Capybara's built-in selectors. Set `DefaultSelector`
to match `Capybara.default_selector`, or to `null` if it varies at
runtime. Queries using custom or unknown selectors are skipped.

# Examples

```ruby
# bad
find('.menu', visible: true)
expect(page).to have_css('.menu', visible: false)

# good
find('.menu', visible: :visible)
find('.menu', visible: :all)
find('.menu', visible: :hidden)

# bad
find(:css, '.menu', visible: true)

# good
find('.menu', visible: true)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/VisibilityOption)