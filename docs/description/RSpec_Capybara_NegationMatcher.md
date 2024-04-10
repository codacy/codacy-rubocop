
Enforces use of `have_no_*` or `not_to` for negated expectations.

# Examples

```ruby
# bad
expect(page).to have_no_selector
expect(page).to have_no_css('a')

# good
expect(page).not_to have_selector
expect(page).not_to have_css('a')# bad
expect(page).not_to have_selector
expect(page).not_to have_css('a')

# good
expect(page).to have_no_selector
expect(page).to have_no_css('a')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Capybara/NegationMatcher)