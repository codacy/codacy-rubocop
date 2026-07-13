
Checks for usage of deprecated assert style method.

# Examples

```ruby
# bad
page.find(:css, '#first').assert_style(display: 'block')

# good
page.find(:css, '#first').assert_matches_style(display: 'block')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/AssertStyle)