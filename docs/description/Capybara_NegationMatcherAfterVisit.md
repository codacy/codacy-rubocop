
Do not allow negative matchers to be used immediately after `visit`.

# Examples

```ruby
# bad
visit foo_path
expect(page).to have_no_link('bar')
expect(page).to have_css('a')

# good
visit foo_path
expect(page).to have_css('a')
expect(page).to have_no_link('bar')

# bad
visit foo_path
expect(page).not_to have_link('bar')
expect(page).to have_css('a')

# good
visit foo_path
expect(page).to have_css('a')
expect(page).not_to have_link('bar')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/NegationMatcherAfterVisit)