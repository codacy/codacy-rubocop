
Checks for there is a more specific actions offered by Capybara.

# Examples

```ruby

# bad
find('a[href="/home"]').click
find('button.cls').click
find('a[href="/home"]', exact_text: 'foo').click
find('div button').click

# good
click_link(href: '/home')
click_button(class: 'cls')
click_link(href: '/home', exact_text: 'foo')
find('div').click_button
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/SpecificActions)