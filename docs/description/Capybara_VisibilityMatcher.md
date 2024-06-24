
Checks for boolean visibility in Capybara finders.

Capybara lets you find elements that match a certain visibility using
the `:visible` option. `:visible` accepts both boolean and symbols as
values, however using booleans can have unwanted effects. `visible:
false` does not find just invisible elements, but both visible and
invisible elements. For expressiveness and clarity, use one of the
symbol values, `:all`, `:hidden` or `:visible`.
Read more in
https://www.rubydoc.info/gems/capybara/Capybara%2FNode%2FFinders:all[the documentation].

# Examples

```ruby
# bad
expect(page).to have_selector('.foo', visible: false)
expect(page).to have_css('.foo', visible: true)
expect(page).to have_link('my link', visible: false)

# good
expect(page).to have_selector('.foo', visible: :visible)
expect(page).to have_css('.foo', visible: :all)
expect(page).to have_link('my link', visible: :hidden)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/VisibilityMatcher)