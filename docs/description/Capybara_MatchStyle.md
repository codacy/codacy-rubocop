
Checks for usage of deprecated style methods.

# Examples

```ruby
# bad
page.find(:css, '#first').assert_style(display: 'block')

# good
page.find(:css, '#first').assert_matches_style(display: 'block')# bad
expect(page.find(:css, 'first')
  .has_style?(display: 'block')).to be true

# good
expect(page.find(:css, 'first')
  .matches_style?(display: 'block')).to be true# bad
expect(page).to have_style(display: 'block')

# good
expect(page).to match_style(display: 'block')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/MatchStyle)