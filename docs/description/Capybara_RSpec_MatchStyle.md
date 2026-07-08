
Checks for usage of deprecated style methods in RSpec matchers.

# Examples

```ruby
# bad
expect(page.find(:css, 'first')
  .has_style?(display: 'block')).to be true

# good
expect(page.find(:css, 'first')
  .matches_style?(display: 'block')).to be true# bad
expect(page).to have_style(display: 'block')

# good
expect(page).to match_style(display: 'block')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/RSpec/MatchStyle)