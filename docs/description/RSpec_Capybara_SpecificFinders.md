
Checks if there is a more specific finder offered by Capybara.

# Examples

```ruby
# bad
find('#some-id')
find('[visible][id=some-id]')

# good
find_by_id('some-id')
find_by_id('some-id', visible: true)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Capybara/SpecificFinders)