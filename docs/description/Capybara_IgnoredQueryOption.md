
Checks for query options that have no effect in Capybara.

Count options passed to singular finders are not autocorrected because
removing them may conceal the author's intent.

This cop targets Capybara's built-in selectors. Set `DefaultSelector`
to match `Capybara.default_selector`, or to `null` if it varies at
runtime. Queries using custom or unknown selectors are skipped.

# Examples

```ruby
# bad
find('.row', count: 3)
find(:css, '.item', exact: true)
find('.item', text: /foo/, exact_text: true)
all(:css, '.item', match: :first)
expect(page).to have_css('.item', count: 3, minimum: 1)

# good
all('.row', count: 3)
find(:css, '.item')
find('.item', text: /foo/)
all(:css, '.item')
expect(page).to have_css('.item', count: 3)

# bad
find(:css, '.item', text: /foo/, exact_text: true)

# good
find('.item', text: /foo/, exact_text: true)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/IgnoredQueryOption)