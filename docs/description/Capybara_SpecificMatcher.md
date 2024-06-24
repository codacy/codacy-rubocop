
Checks for there is a more specific matcher offered by Capybara.

# Examples

```ruby

# bad
expect(page).to have_selector('button')
expect(page).to have_no_selector('button.cls')
expect(page).to have_css('button')
expect(page).to have_no_css('a.cls', href: 'http://example.com')
expect(page).to have_css('table.cls')
expect(page).to have_css('select')
expect(page).to have_css('input', exact_text: 'foo')

# good
expect(page).to have_button
expect(page).to have_no_button(class: 'cls')
expect(page).to have_button
expect(page).to have_no_link('foo', class: 'cls', href: 'http://example.com')
expect(page).to have_table(class: 'cls')
expect(page).to have_select
expect(page).to have_field(with: 'foo')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/SpecificMatcher)