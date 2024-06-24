
Checks for there is a more specific actions offered by Capybara.

# Examples

```ruby

# bad
find('a').click
find('button.cls').click
find('a', exact_text: 'foo').click
find('div button').click

# good
click_link
click_button(class: 'cls')
click_link(exact_text: 'foo')
find('div').click_button
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/SpecificActions)