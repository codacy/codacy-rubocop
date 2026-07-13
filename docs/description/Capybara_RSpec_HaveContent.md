
Checks for usage of `have_content` and `have_no_content`.

Capybara provides `have_text` and `have_no_text` matchers that are
more concise and preferred over their aliases `have_content` and
`have_no_content`.

# Examples

```ruby
# bad
expect(page).to have_content('capy')
expect(page).to have_no_content('bara')

# good
expect(page).to have_text('capy')
expect(page).to have_no_text('bara')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/RSpec/HaveContent)