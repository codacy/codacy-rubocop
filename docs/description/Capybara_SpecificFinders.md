
Checks if there is a more specific finder offered by Capybara.

# Examples

```ruby
# bad
find('#some-id')
find('[id=some-id]')
find(:css, '#some-id')
find(:id, 'some-id')
find(:link, 'Home')
find(:field, 'Name')
find('input[placeholder="Email"]')
find(:css, 'input[type="checkbox"]')

# good
find_by_id('some-id')
find_link('Home')
find_field('Name')
find_field(placeholder: 'Email')
find_field(type: 'checkbox')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/SpecificFinders)