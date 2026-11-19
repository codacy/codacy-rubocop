
Checks for boolean visibility in Capybara RSpec matchers.

Capybara lets you find elements that match a certain visibility using
the `:visible` option. `:visible` accepts both boolean and symbols as
values, however using booleans can have unwanted effects. `visible:
false` does not find just invisible elements, but both visible and
invisible elements. For expressiveness and clarity, use one of the
symbol values, `:all`, `:hidden` or `:visible`.
Only `true` is autocorrected, to `:visible`.
Set `DefaultSelector` to match `Capybara.default_selector`, or to
`null` if it varies at runtime.
Read more at: https://www.rubydoc.info/gems/capybara/Capybara%2FNode%2FFinders:all

# Examples

```ruby
# bad
expect(page).to have_selector('.foo', visible: true)
expect(page).to have_css('.foo', visible: false)
expect(page).to have_link('my link', visible: false)

# good
expect(page).to have_selector('.foo', visible: :visible)
expect(page).to have_css('.foo', visible: :all)
expect(page).to have_link('my link', visible: :hidden)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/RSpec/VisibilityMatcher)